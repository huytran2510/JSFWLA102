package fa.training.services;


import fa.training.dto.create.ClientRegisterDTO;
import fa.training.entities.User;
import fa.training.entities.enums.ERole;
import fa.training.repository.RoleRepository;
import fa.training.repository.UserRepository;
import fa.training.services.templates.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public boolean login(String userName, String passWord) {
        User user = userRepository.findUserByUsername(userName);
        return user != null && passWord.equals(user.getPassword());
    }

    @Override
    public void save(ClientRegisterDTO cUser) {
        User user = new User(cUser);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findByName(ERole.USER)));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
