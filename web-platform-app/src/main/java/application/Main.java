package application;


import model.transaction.BuyOrder;
import model.transaction.SellOrder;
import model.user.User;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static final List<BuyOrder> BUY_ORDERS = buildBuyOrders();

    private static final List<SellOrder> SELL_ORDERS = buildSellOrders();

    private static final List<User> USERS = buildUsers();

    private static List<User> buildUsers() {
        return null;
    }

    private static List<SellOrder> buildSellOrders() {
        return null;
    }

    private static List<BuyOrder> buildBuyOrders() {
        return null;
    }

    public static void main(String[] args) {
        IntStream.range(0, 80).forEach(i -> System.out.print('*'));
        System.out.println();
        IntStream.range(0, 10).forEach(j -> IntStream.range(0, 80).forEach(i -> {
                    if (i == 79) {
                        System.out.println('*');
                    } else {
                        if (i == 0) {
                            System.out.print('*');
                        } else {
                            System.out.print("");
                        }
                    }
                }
        ));
            IntStream.range(0, 80).forEach(i -> System.out.print('*'));
            System.out.println();
        }

    }
