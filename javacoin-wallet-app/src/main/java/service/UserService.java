package service;

import model.User;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class UserService {

    static final Map<String,User> USERS;
    static  {
      USERS = new HashMap<>();
    }
    public static User findUser(String offereeUsername) {
        return USERS.get(offereeUsername);
    }
}
