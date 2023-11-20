package model.transaction.factory.impl;

import model.enums.OrderType;
import model.enums.Status;
import model.transaction.BuyOrder;
import model.transaction.Order;
import model.transaction.SellOrder;
import model.transaction.factory.OrderFactory;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderFactoryImpl implements OrderFactory {

    public Order createOrder(OrderType orderType, BigDecimal amount, String username, BigDecimal price, String offereeUsername) {
        if (orderType.equals(OrderType.BUY)) {
            return BuyOrder.builder().orderUUID(UUID.randomUUID())
                    .bidderUsername(username)
                    .offereeUsername(offereeUsername)
                    .amount(amount)
                    .price(price)
                    .status(Status.PENDING)
                    .build();
        }
        if (orderType.equals(OrderType.SELL)) {
            return SellOrder.builder().orderUUID(UUID.randomUUID())
                    .bidderUsername(username)
                    .offereeUsername(offereeUsername)
                    .amount(amount)
                    .price(price)
                    .status(Status.PENDING)
                    .build();
        }
        return null;
    }
}