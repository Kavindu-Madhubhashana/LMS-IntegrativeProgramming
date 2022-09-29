package lk.ac.kln.lms.service;

import jakarta.transaction.Transactional;
import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.repo.AppUserRepo;
import lk.ac.kln.lms.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public AppUser saveUser(AppUser user) {
        return  null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, Role roleName) {

    }

    @Override
    public AppUser getUser(String username) {
        return null;
    }

    @Override
    public List<AppUser> getUsers() {
        return null;
    }
}
