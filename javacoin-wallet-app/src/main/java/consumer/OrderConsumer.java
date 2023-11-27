package consumer;

import model.User;
import model.Wallet;
import model.Order;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import service.UserService;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrderConsumer {


    public static final String ACCEPTED_TOPIC = "AcceptedTopic";

    public void consume() throws NamingException {
        InitialContext initialContext = new InitialContext();
        try (ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = activeMQConnectionFactory.createContext(JMSContext.SESSION_TRANSACTED)) {
            Topic topic = (Topic) initialContext.lookup(ACCEPTED_TOPIC);
            JMSConsumer jmsConsumer = jmsContext.createConsumer(topic);
            Order order = jmsConsumer.receiveBody(Order.class);
            User buyer = UserService.findUserByUsername(order.getOffereeUsername());
            User seller = UserService.findUserByUsername(order.getBidderUsername());
            if (Objects.isNull(buyer.getWallet())) {
                buyer.setWallet(Wallet
                        .builder()
                        .amount(BigDecimal.ZERO)
                        .walletId(UUID.randomUUID())
                        .build());

            }
            if (Objects.isNull(seller.getWallet())) {
                jmsContext.rollback();
            } else if (seller.getWallet().getAmount().subtract(order.getAmount()).signum() < 0) jmsContext.rollback();
            else {
                seller.getWallet().setAmount(seller.getWallet().getAmount().subtract(order.getAmount()));
                buyer.getWallet().setAmount(buyer.getWallet().getAmount().add(order.getAmount()));
                jmsContext.commit();
            }
        }
    }
}
