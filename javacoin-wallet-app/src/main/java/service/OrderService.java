package service;

import exception.AlreadyProcessedOrderException;
import model.User;
import model.Wallet;
import model.transaction.Order;
import model.transaction.enums.Status;

public class OrderService {

    public Order validateAndProcessOrder(Order order) throws AlreadyProcessedOrderException {
        validateOrder(order);
        User user = UserService.findUser(order.getOffereeUsername());
        Wallet wallet = user.getWallet();
        AcceptOrRejectOrder(order, wallet);
        return order;
    }

    private void AcceptOrRejectOrder(Order order, Wallet wallet) {
        if(wallet.getAmount().subtract(order.getAmount()).signum() >= 0 ) {
            order.setStatus(Status.ACCEPTED);

        } else {
            order.setStatus(Status.REJECTED);
        }
    }

    private void validateOrder(Order order) throws AlreadyProcessedOrderException {
        if(order.getStatus().equals(Status.REJECTED) || order.getStatus().equals(Status.EXECUTED)){
            throw new AlreadyProcessedOrderException();
        }
    }
}
