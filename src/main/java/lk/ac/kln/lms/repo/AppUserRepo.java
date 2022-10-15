package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> { //AppUser is the type to be managed and Long is the primary key type
    AppUser findByUsername(String username);

    boolean existsByUsername(String username);
}
