package consumer;

import lombok.Builder;
import model.user.User;

import javax.naming.InitialContext;
import javax.naming.NamingException;

@Builder
public class JavaCoinOrderConsumer {

    private User user;
    private boolean isActive;
    public void consume() throws NamingException {

        while (this.isActive){
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
