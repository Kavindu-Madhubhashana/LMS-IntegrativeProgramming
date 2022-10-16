package lk.ac.kln.lms.dto;

import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
    private String userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private List<RoleEnum> roles;
}
