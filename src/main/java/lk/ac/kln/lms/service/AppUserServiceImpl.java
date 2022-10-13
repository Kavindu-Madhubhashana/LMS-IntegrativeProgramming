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
        log.info("Saving new user {} to the database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        //log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        // TODO: Add necessary validations
        log.info("Adding role {} to user {}", roleName, username);
        AppUser user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("Fetching user {}", username);
        return null;
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public Optional<AppUser> getAppUserById(Long id) {
        return userRepo.findById(id);
    }
}
