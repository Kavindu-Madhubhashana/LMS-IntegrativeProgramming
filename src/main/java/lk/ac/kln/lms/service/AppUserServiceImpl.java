package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.dto.RegisterUserDto;
import lk.ac.kln.lms.enums.RoleEnum;
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
    public AppUser saveUser(RegisterUserDto user) {
        //check if the user already exists
        boolean exists = userRepo.existsByUsername(user.getUsername());
        log.info("User already exists: {}", exists);

        if (exists) {
            throw new IllegalStateException("Username already exists");
        }
        else{

            AppUser newUser = new AppUser();
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setUsername(user.getUsername());
            newUser.setUserId(user.getUserId());

            log.info("Saving new user {} to the database", user.getName());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            AppUser savedUser = userRepo.save(newUser);
            user.getRoles().forEach((RoleEnum role) -> this.addRoleToUser(newUser.getUsername(), role));
            return savedUser;
        }
    }

    @Override
    public Role saveRole(Role role) {
        //log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, RoleEnum roleName) {
        // TODO: Add necessary validations
        log.info("Adding role {} to user {}", roleName, username);
        Optional<AppUser> user = userRepo.findByUsername(username);
        if(user.isPresent()) {
            Role role = roleRepo.findByName(roleName);
            user.get().getRoles().add(role);
        }
    }

    @Override
    public AppUser getUser(String username) {
        Optional<AppUser> foundUser = userRepo.findByUsername(username);
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
        Optional<AppUser> user = userRepo.findByUsername(username);
        if(user.isEmpty()) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.get().getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
        });
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), authorities);
    }
}
