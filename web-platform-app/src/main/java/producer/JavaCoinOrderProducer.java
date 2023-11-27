package producer;

import model.Order;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class JavaCoinOrderProducer {
    public static final String BIDDER_TOPIC = "BidderTopic";
    public void produce(Order order) throws NamingException {

        InitialContext initialContext = new InitialContext();
        try (ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
             JMSContext jmsContext = activeMQConnectionFactory.createContext(JMSContext.SESSION_TRANSACTED)) {
            Topic topic = (Topic) initialContext.lookup(BIDDER_TOPIC);
            JMSProducer jmsProducer = jmsContext.createProducer();
            jmsProducer.send(topic, order);
            jmsContext.commit();
        }
    }

}
