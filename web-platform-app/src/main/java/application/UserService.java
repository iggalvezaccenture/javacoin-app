package application;

import model.User;

import java.util.HashMap;
import java.util.Map;

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
                .build());
        users.put(ALBERTO_2023, User.builder()
                .username(ALBERTO_2023)
                .build());
        users.put(AMALIA_2022, User.builder()
                .username(UserService.AMALIA_2022)
                        .build());
        users.put(JUAN_GOMEZ, User.builder()
                .username(JUAN_GOMEZ)
                .build());
        users.put(JACINTO, User.builder()
                .username(UserService.JACINTO)
                .build());
        users.put(MARIA, User.builder()
                .username(MARIA)
                .build());
    }
    public static User findUserByUsername(String username) {
        return users.get(username);
    }
}
