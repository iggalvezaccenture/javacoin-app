package consumer;

import lombok.Builder;
import model.BankAccount;
import model.User;
import model.Order;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import service.UserService;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.math.BigDecimal;

public class OrderConsumer {

    public static final String ORDERS_TOPIC = "OrdersTopic";
    private static final String ACCEPTED_TOPIC = "AcceptedTopic";


    public void consume() throws NamingException {

        InitialContext initialContext = new InitialContext();
        try (ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = activeMQConnectionFactory.createContext(JMSContext.SESSION_TRANSACTED)) {
            Topic topic = (Topic) initialContext.lookup(ORDERS_TOPIC);
            JMSConsumer consumer = jmsContext.createConsumer(topic);

            Order order = consumer.receiveBody(Order.class);
            User buyer = UserService.findUserByUsername(order.getBidderUsername());
            BankAccount bankAccount = buyer.getBankAccount();
            BigDecimal commision = this.getCommission(buyer);
            if (bankAccount.getAmount().subtract(order.getAmount().multiply(order.getPrice()).multiply(
                    commision
            )).signum() < 0) {
                jmsContext.rollback();
            } else {
                bankAccount.setAmount(bankAccount.getAmount().subtract(order.getAmount().multiply(order.getPrice()).multiply(
                        commision
                )));
                buyer.setOperationsCount(buyer.getOperationsCount() + 1);
                JMSProducer jmsProducer = jmsContext.createProducer();
                Topic acceptedTopic = (Topic) initialContext.lookup(ACCEPTED_TOPIC);
                jmsProducer.send(acceptedTopic, order);
                jmsContext.commit();
            }
        }
    }

    private BigDecimal getCommission(User buyer) {
        if (buyer.getOperationsCount() < 3) {
            return BigDecimal.valueOf(1.05);
        }
        if (buyer.getOperationsCount() >= 3 && buyer.getOperationsCount() < 6) {
            return BigDecimal.valueOf(1.03);
        }
        return BigDecimal.ONE;
    }
}
