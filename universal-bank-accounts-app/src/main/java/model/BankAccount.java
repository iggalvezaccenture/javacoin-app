package model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BankAccount {

    private UUID accountId;

    private String number;

    private User user;

    private BigDecimal amount;

    private BigDecimal deductions;

}
