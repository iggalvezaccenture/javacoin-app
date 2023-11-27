package service;

import model.BankAccount;
import model.User;

import java.math.BigDecimal;
import java.util.*;

public class UserService {
    private static final Map<String, User> users;

    public static final String FLORENCIA = "Florencia";

    public static final String ALBERTO_2023 = "Alberto2023";

    public static final String AMALIA_2022 = "Amalia2022";


    public static final String JUAN_GOMEZ = "Juan.gomez";

    public static final String JACINTO = "Jacinto";


    public static final String MARIA = "Maria";

    static {
        users = new HashMap<>();
        users.put(FLORENCIA, User.builder()
                .username(FLORENCIA)
                .operationsCount(0)
                .bankAccount(BankAccount.builder()
                        .amount(BigDecimal.valueOf(1000)
                        )
                        .number(1234567L)
                        .build())
                .build());
        users.put(ALBERTO_2023, User.builder()
                .username(ALBERTO_2023)
                .operationsCount(0)
                .bankAccount(BankAccount.builder()
                        .amount(BigDecimal.valueOf(100000)
                        )
                        .number(12333567L)
                        .build())
                .build());
        users.put(AMALIA_2022, User.builder()
                .username(UserService.AMALIA_2022)
                .operationsCount(0)
                .bankAccount(BankAccount.builder()
                        .amount(BigDecimal.valueOf(1000000)
                        )
                        .number(234234567L)
                        .build())
                .build());
        users.put(JUAN_GOMEZ, User.builder()
                .username(JUAN_GOMEZ)
                .operationsCount(0)
                .bankAccount(BankAccount.builder()
                        .amount(BigDecimal.valueOf(100)
                        )
                        .number(1111234567L)
                        .build())
                .build());
        users.put(JACINTO, User.builder()
                .username(UserService.JACINTO)
                .operationsCount(0)
                .bankAccount(BankAccount.builder()
                        .amount(BigDecimal.valueOf(10)
                        )
                        .number(12345633337L)
                        .build())
                .build());
        users.put(MARIA, User.builder()
                .username(MARIA)
                .operationsCount(0)
                .bankAccount(BankAccount.builder()
                        .amount(BigDecimal.valueOf(230000)
                        )
                        .number(2222234567L)
                        .build())
                .build());

    }

    public static User findUserByUsername(String username) {
        return users.get(username);
    }
}
