package model.user;

import lombok.Builder;
import lombok.Data;
import model.enums.OrderType;
import model.transaction.BuyOrder;
import model.transaction.SellOrder;
import model.transaction.factory.OrderFactory;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
@Data
@Builder
public class User {
    private UUID id;
    private String username;
    private Map<UUID,SellOrder> sellOrders;
    private Map<UUID,BuyOrder> buyOrders;
    private OrderFactory factory;

    public SellOrder sell(User offeree, BigDecimal amount, BigDecimal price) {
        SellOrder sellOrder = (SellOrder) this.factory
                .createOrder(OrderType.SELL,amount,this.username,price,offeree.getUsername());
        sellOrders.put(sellOrder.getOrderUUID(),sellOrder);
        return sellOrder;

    }

    public BuyOrder buy(User offeree, BigDecimal amount, BigDecimal price) {
        BuyOrder buyOrder = (BuyOrder) this.factory
                .createOrder(OrderType.BUY,amount,this.username,price,offeree.getUsername());
        buyOrders.put(buyOrder.getOrderUUID(),buyOrder);
        return buyOrder;

    }
    public SellOrder closeSellOrder(SellOrder sellOrder){
         return this.sellOrders.remove(sellOrder.getOrderUUID());
    }

    public BuyOrder closeBuyOrder(BuyOrder buyOrder){
        return this.buyOrders.remove(buyOrder.getOrderUUID());
    }
}
