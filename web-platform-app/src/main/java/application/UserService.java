package application;

import model.user.User;

import java.util.Arrays;
import java.util.List;

public class UserService {


    public static List<User> users =
            Arrays.asList(User.builder()
                    .username("Florencia").build(),
                    User.builder().username("Alberto2023").build(),
                    User.builder()
                            .username("Amalia2022").build(),
                    User.builder().username("Juan.gomez").build(),
                    User.builder()
                            .username("Jacinto").build(),
                    User.builder().username("Maria").build());
}
