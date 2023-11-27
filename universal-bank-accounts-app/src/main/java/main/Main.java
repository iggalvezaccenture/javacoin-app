package main;

import consumer.OrderConsumer;

import javax.naming.NamingException;

public class Main {

    public static void main(String[] args) throws NamingException {


        OrderConsumer orderConsumer = new OrderConsumer();
        orderConsumer.consume();
        orderConsumer.consume();


    }
}
