package application.main;

import application.UserService;
import consumer.JavaCoinOrderConsumer;
import model.Order;
import producer.JavaCoinOrderProducer;

import javax.naming.NamingException;
import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) throws NamingException {
        JavaCoinOrderProducer javaCoinOrderProducer = new JavaCoinOrderProducer();
        JavaCoinOrderConsumer javaCoinOrderConsumer = new JavaCoinOrderConsumer();

        Order one = Order.builder()
                .amount(BigDecimal.valueOf(100))
                .price(BigDecimal.TEN)
                .bidderUsername(UserService.findUserByUsername(UserService.MARIA).getUsername())
                .build();
        Order two = Order.builder()
                .amount(BigDecimal.valueOf(45))
                .price(BigDecimal.TEN)
                .bidderUsername(UserService.findUserByUsername(UserService.AMALIA_2022).getUsername())
                .build();

        javaCoinOrderProducer.produce(one);
        javaCoinOrderProducer.produce(two);

        javaCoinOrderConsumer.consume(UserService.findUserByUsername(UserService.FLORENCIA));
        javaCoinOrderConsumer.consume(UserService.findUserByUsername(UserService.ALBERTO_2023));

    }
}
