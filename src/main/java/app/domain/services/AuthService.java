package app.domain.services;

import app.domain.models.User;
import app.ports.UserPort;

public class AuthService {
    private final UserPort userPort;

    public AuthService(UserPort userPort) {
        this.userPort = userPort;
    }

    public void registerUser(String username, String password, String role) throws Exception {
        if (userPort.existUserName(username)) {
            throw new Exception("El nombre de usuario ya existe.");
        }
        User user = new User(0, 0, "", 0, 0, username, password, role);
        userPort.saveUser(user);
    }

    public User authenticate(String username, String password) {
        return userPort.findByUsernameAndPassword(username, password);
    }
}
