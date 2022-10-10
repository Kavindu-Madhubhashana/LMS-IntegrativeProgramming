package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
