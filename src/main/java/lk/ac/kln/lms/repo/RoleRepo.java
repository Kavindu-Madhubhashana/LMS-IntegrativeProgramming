package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;

public interface RoleRepo  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
