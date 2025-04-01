package app.ports;

import app.domain.models.User;

public interface UserPort {
    boolean existUserName(String userName);
    void saveUser(User user);
    User findByUsernameAndPassword(String username, String password);
}
