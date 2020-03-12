package app.service;

import app.dao.UserDAO;

public class UserService {
    UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
