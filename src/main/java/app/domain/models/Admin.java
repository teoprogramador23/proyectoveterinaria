package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Admin extends User {
    public Admin(long personId, long document, String name, long cellPhone, long userId, String userName, String password) {
        super(personId, document, name, cellPhone, userId, userName, password, "admin");
    }
}

