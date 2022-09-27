package lk.ac.kln.lms.repo;

import lk.ac.kln.lms.domain.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> { //AppUser is the type to be managed and Long is the primary key type
    AppUser findByUsername(String username);
}
