package consumer;

import lombok.Builder;
import model.BankAccount;
import model.User;
import model.transaction.Order;
import model.transaction.enums.Status;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import service.UserService;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Builder
public class BankAccountConsumer {

    private boolean isActive;


    public void consume() throws NamingException {

        InitialContext initialContext = new InitialContext();
        try (ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = activeMQConnectionFactory.createContext()) {
            Topic topic = (Topic) initialContext.lookup("OrdersTopic");
            JMSConsumer consumer = jmsContext.createConsumer(topic);
            while (this.isActive) {
                Order order = consumer.receiveBody(Order.class);
                User user = UserService.findUserByUsername(order.getBidderUsername());
                BankAccount bankAccount = user.getBankAccount();
                if (bankAccount.getDeductions().subtract(order.getAmount().multiply(order.getPrice())).signum() < 0) {
                    order.setStatus(Status.REJECTED);
                } else {
                    bankAccount.setDeductions(bankAccount.getAmount().subtract(order.getAmount().multiply(order.getAmount())));
                    order.setStatus(Status.ACCEPTED);
                }
            }
        }
    }

    public void start() {
        this.isActive = true;
    }

    public void stop() {
        this.isActive = false;
    }
}
