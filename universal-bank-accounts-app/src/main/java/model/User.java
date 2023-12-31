package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String DNI;

    private String username;

    private String name;

    private String surname;

    private BankAccount bankAccount;

    private Integer operationsCount;

}
