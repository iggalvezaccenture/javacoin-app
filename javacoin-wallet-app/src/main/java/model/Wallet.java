package model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Wallet {
    private UUID walletId;
    private User user;
    private BigDecimal amount;
}
