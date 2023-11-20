package service;

import model.User;
import model.Wallet;
import model.transaction.Order;
import model.transaction.enums.Status;

public class OrderService {

    public Order validateAndProcessOrder(Order order) {
        User user = UserService.findUser(order.getOffereeUsername());
        Wallet wallet = user.getWallet();
        if(wallet.getAmount().subtract(order.getAmount()).signum() >= 0 ) {
            order.setStatus(Status.ACCEPTED);

        } else {
            order.setStatus(Status.REJECTED);
        }
        return order;
    }
}
