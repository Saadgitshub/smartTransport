package Main.Controllers;

import Main.dao.UserDAO;
import Main.Models.User;

import java.util.List;

public class UserController {
    private final UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    public void createUser(User user) {
        UserDAO.createUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public boolean addUser(User newUser) {
        return false;
    }
}
