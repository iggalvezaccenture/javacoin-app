package service;

import model.User;
import model.Wallet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
                .DNI("324567899")
                .wallet(Wallet.builder()
                        .walletId(UUID.randomUUID())
                        .amount(BigDecimal.valueOf(10))
                        .build())
                .build());
        users.put(ALBERTO_2023, User.builder()
                .username(ALBERTO_2023)
                        .DNI("354567899")
                        .build());
        users.put(AMALIA_2022, User.builder()
                .username(UserService.AMALIA_2022)
                .wallet(Wallet.builder()
                        .walletId(UUID.randomUUID())
                        .amount(BigDecimal.valueOf(100))
                        .build())
                .build());
        users.put(JUAN_GOMEZ, User.builder()
                .username(JUAN_GOMEZ)
                        .DNI("353567899")
                .wallet(Wallet.builder()
                        .walletId(UUID.randomUUID())
                        .amount(BigDecimal.valueOf(10000))
                        .build())
                .build());
        users.put(JACINTO, User.builder()
                .username(UserService.JACINTO)
                .DNI("3545678933")
                .build());
        users.put(MARIA, User.builder()
                .username(MARIA)
                .DNI("3545678223")
                .wallet(Wallet.builder()
                        .walletId(UUID.randomUUID())
                        .amount(BigDecimal.valueOf(5))
                        .build())
                .build());
    }
    public static User findUserByUsername(String username) {
        return users.get(username);
    }
}
