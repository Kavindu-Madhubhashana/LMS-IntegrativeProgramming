package lk.ac.kln.lms.service;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.dto.RegisterUserDto;
import lk.ac.kln.lms.enums.RoleEnum;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser saveUser(RegisterUserDto user);
    Role saveRole(Role role);
    void addRoleToUser(String username, RoleEnum roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();

    Optional<AppUser> getAppUserById(final Long id);
}
