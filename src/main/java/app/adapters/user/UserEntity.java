package app.adapters.user.entity;

import app.domain.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column(unique = true, nullable = false)
    private String userName;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String role;

    public UserEntity(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}

