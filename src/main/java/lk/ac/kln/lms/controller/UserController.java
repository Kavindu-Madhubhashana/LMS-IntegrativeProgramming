package lk.ac.kln.lms.controller;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.dto.FindUserDto;
import lk.ac.kln.lms.dto.RegisterUserDto;
import lk.ac.kln.lms.enums.RoleEnum;
import lk.ac.kln.lms.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController @RequiredArgsConstructor @RequestMapping("/api/v1/user")
public class UserController {
    private final AppUserService userService;

    @GetMapping("")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("get")
    public ResponseEntity<AppUser> getUserByUsername(@RequestBody FindUserDto userInfo) {
        try {
            return new ResponseEntity<>(userService.getUser(userInfo.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(userService.getUser(userInfo.getUsername()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody RegisterUserDto user) {

        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> saveRole(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String username;
    private RoleEnum roleName;
}