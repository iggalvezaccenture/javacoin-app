package model;

import lombok.Data;

import java.util.UUID;

@Data
public class BankAccount {

    private UUID accountId;

    private String number;

    private User user;
}
