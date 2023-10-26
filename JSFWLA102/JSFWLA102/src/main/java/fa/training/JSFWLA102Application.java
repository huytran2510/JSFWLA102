package fa.training;

import fa.training.entities.Role;
import fa.training.entities.User;
import fa.training.entities.enums.ERole;
import fa.training.repository.RoleRepository;
import fa.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class JSFWLA102Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(JSFWLA102Application.class, args);
    }
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        Role roleUser = new Role(ERole.USER);
//        Role roleAdmin = new Role(ERole.ADMIN);
//        roleRepository.save(roleUser);
//        roleRepository.save(roleAdmin);
//        User user = new User("huyle", bCryptPasswordEncoder.encode("123456"));
//        user.setRoles(new HashSet<>(roleRepository.findByName(ERole.ADMIN)));
//        userRepository.save(user);
    }
}
