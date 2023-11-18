package model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID uuid;

    private String DNI;

    private String username;

    private String name;

    private String surname;

    private BankAccount bankAccount;

}
