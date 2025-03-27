package app.ports;

import app.domain.models.Person;
import app.domain.models.User;

public interface UserPort {
   boolean existsUserName(String userName);
   void saveUser(User user);
   User findByPersonId(Person person);
}

