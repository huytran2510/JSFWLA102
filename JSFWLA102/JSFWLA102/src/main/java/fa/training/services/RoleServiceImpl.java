package fa.training.services;

import fa.training.entities.Role;
import fa.training.repository.RoleRepository;
import fa.training.services.templates.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    public void save(Role role) {
        roleRepository.save(role);
    }
}
