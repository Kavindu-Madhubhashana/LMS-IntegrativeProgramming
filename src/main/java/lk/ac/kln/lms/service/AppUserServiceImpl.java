package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.repo.AppUserRepo;
import lk.ac.kln.lms.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    @Autowired
    private final AppUserRepo userRepo;

    @Autowired
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public AppUser saveUser(AppUser user) {
        //check if the user already exists
        boolean exists = userRepo.existsByUsername(user.getUsername());
        log.info("User already exists: {}", exists);

        if (exists) {
            throw new IllegalStateException("Username already exists");
        }
        else{
            log.info("Saving new user {} to the database", user.getName());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
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
        Optional<AppUser> foundUser = Optional.of(userRepo.findByUsername(username));
        if(foundUser.isPresent()) {
            return foundUser.get();
        } else throw new IllegalStateException("User not found");
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("user = " + username);
        AppUser user = userRepo.findByUsername(username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
