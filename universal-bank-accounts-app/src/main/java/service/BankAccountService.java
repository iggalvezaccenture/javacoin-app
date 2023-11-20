package service;

import model.BankAccount;
import model.User;

import java.math.BigDecimal;

public class BankAccountService {

    public void deposit(User user , BigDecimal amount){
        BankAccount bankAccount = user.getBankAccount();
        bankAccount.setAmount(bankAccount.getAmount().add(amount));
    }
}
