package fa.training.entities;

import fa.training.dto.create.ClientRegisterDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "dbo" , name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column
    private String salt;

    @Column
    private String email;

    @Column
    private String profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Post> post;

    @ManyToMany
    private Set<Role> roles;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(ClientRegisterDTO userCreateDTO) {
        this.username = userCreateDTO.getUsername();
        this.password = userCreateDTO.getPassword();
        this.salt = userCreateDTO.getSalt();
        this.email = userCreateDTO.getEmail();
        this.profile = userCreateDTO.getProfile();
    }

}
