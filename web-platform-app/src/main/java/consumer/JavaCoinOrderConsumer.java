package consumer;

import model.Order;
import model.User;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class JavaCoinOrderConsumer {

    public static final String ORDERS_TOPIC = "OrdersTopic";
    public static final String BIDDER_TOPIC = "BidderTopic";

    public void consume(User user) throws NamingException {
        InitialContext initialContext = new InitialContext();
        try (ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = activeMQConnectionFactory.createContext(JMSContext.SESSION_TRANSACTED)) {
            Topic topic = (Topic) initialContext.lookup(BIDDER_TOPIC);
            JMSConsumer jmsConsumer = jmsContext.createConsumer(topic);
            Order order = jmsConsumer.receiveBody(Order.class);
            order.setOffereeUsername(user.getUsername());
            Topic orderTopic = (Topic) initialContext.lookup(ORDERS_TOPIC);
            JMSProducer jmsProducer = jmsContext.createProducer();
            jmsProducer.send(orderTopic,order);
            jmsContext.commit();

        }
    }
}