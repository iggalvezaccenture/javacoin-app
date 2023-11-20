package model.transaction.factory;

import model.enums.OrderType;
import model.transaction.Order;

import java.math.BigDecimal;

public interface OrderFactory {

    Order createOrder(OrderType orderType, BigDecimal amount, String username, BigDecimal price, String offereeUsername);
}
