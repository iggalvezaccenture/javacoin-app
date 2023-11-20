package service;

import exception.AlreadyProcessedOrderException;
import exception.NonAcceptedOrderException;
import model.BankAccount;
import model.User;
import model.transaction.Order;
import model.transaction.enums.Status;

import java.util.Objects;

public class OrderService {

    public Order validateAndAcceptOrRejectOrder(Order order) throws AlreadyProcessedOrderException {

        validateIfOrderIsPending(order);
        User user = UserService.findUser(order.getOffereeDNI());
        BankAccount bankAccount = user.getBankAccount();
        AcceptOrRejectOrder(order, bankAccount);

        return order;
    }

    private void validateIfOrderIsPending(Order order) throws AlreadyProcessedOrderException {
        if (!Objects.equals(order.getStatus(), Status.PENDING)) {
            throw new AlreadyProcessedOrderException();
        }
    }


    public Order validateAndExecuteOrder(Order order) throws NonAcceptedOrderException {
        validateIfAcceptedOrder(order);
        User user = UserService.findUser(order.getOffereeDNI());
        updateBankAccount(order, user);
        order.setStatus(Status.EXECUTED);
        return order;
    }

    private void validateIfAcceptedOrder(Order order) throws NonAcceptedOrderException {
        if (!Objects.equals(order.getStatus(), Status.ACCEPTED)) {
            throw new NonAcceptedOrderException();
        }
    }

    private void updateBankAccount(Order order, User user) {
        BankAccount bankAccount = user.getBankAccount();
        bankAccount.setAmount(bankAccount.getAmount().add(order.getAmount()));
    }

    private void AcceptOrRejectOrder(Order order, BankAccount bankAccount) {
        if (bankAccount.getAmount().subtract(order.getAmount()).signum() >= 0) {
            order.setStatus(Status.ACCEPTED);

        } else {
            order.setStatus(Status.REJECTED);
        }
    }

}