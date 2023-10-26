package fa.training.repository;

import fa.training.entities.Role;
import fa.training.entities.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByName(ERole name);
}
