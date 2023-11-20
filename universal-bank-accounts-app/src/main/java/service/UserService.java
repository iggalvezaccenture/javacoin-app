package service;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    static final Map<String, User> USERS;
    static  {
        USERS = new HashMap<>();
    }
    public static User findUser(String dni) {
        return USERS.get(dni);
    }
}