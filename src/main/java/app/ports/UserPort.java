package app.ports;

import app.domain.models.User;

public interface UserPort {
    void saveUser(User user);
    User findByUsername(String username);
}
