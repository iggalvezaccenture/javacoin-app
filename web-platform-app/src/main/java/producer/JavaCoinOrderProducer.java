package producer;

import lombok.Builder;
import model.user.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@Builder
public class JavaCoinOrderProducer {
    private boolean isActive;
    private User user;
    public void produce() throws NamingException {

        while(this.isActive)
        {
            InitialContext initialContext = new InitialContext();
        }
    }

    public void start(){
        this.isActive = true;
    }

    public void stop(){
        this.isActive = false;
    }
}
