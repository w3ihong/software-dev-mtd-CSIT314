package control;

import entity.*;

public class LoginController {

    public User AuthenticateDetails(String username, String password) {
        User user = new User();
        return user.authenticate(username, password);
    }
}
