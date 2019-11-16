package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        boolean userOk = false;
        boolean passOk = false;


        if (username.matches("^[a-z]+$")
             && username.length() >= 3) {
                System.out.println("user ok");
                userOk = true;
        }

        if (password.matches("^[a-z]+.*")
            && password.matches(".*[^a-zA-Z].*")
            && password.length() >= 8) {
                System.out.println("pass ok");
                passOk = true;
        } 

        if (userOk && passOk) {
            return false;
        }

        return true;
    }
}
