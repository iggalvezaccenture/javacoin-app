package service;

import model.User;

import java.math.BigDecimal;

public class WalletService {

    public void deposit(BigDecimal amount, User user){
        user.getWallet().setAmount(user.getWallet().getAmount().add(amount));

    }
}
