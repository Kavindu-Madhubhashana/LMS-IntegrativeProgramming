package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.repo.AppUserRepo;
import lk.ac.kln.lms.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private final AppUserRepo userRepo;

    @Autowired
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

    @Override
    public Optional<AppUser> getAppUserById(Long id) {
        return userRepo.findById(id);
    }
}
