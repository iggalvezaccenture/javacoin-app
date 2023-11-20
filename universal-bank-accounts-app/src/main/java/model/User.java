package model;

import lombok.Data;

@Data
public class User {

    private String DNI;

    private String username;

    private String name;

    private String surname;

    private BankAccount bankAccount;

}
