package app.adapters.user;

import app.domain.models.User;
import app.ports.UserPort;

public class UserAdapter implements UserPort {
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        UserEntity entity = new UserEntity(user);
        userRepository.save(entity);
        user.setUserId(entity.getUserId());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).toModel();
    }
}
