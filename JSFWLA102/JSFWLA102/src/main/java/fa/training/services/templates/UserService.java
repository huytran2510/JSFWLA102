package fa.training.services.templates;

import fa.training.dto.create.ClientRegisterDTO;
import fa.training.entities.User;

public interface UserService {
    public boolean login(String username, String password);

    void save(ClientRegisterDTO CUser);

    User findByUsername(String username);
}
