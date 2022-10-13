package lk.ac.kln.lms;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		System.out.println("Hello From SF PRO");
		//System.out.println("Hello From SF PRO");
		SpringApplication.run(LmsApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_STUDENT"));
			userService.saveRole(new Role(null, "ROLE_TEACHER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new AppUser(null, "IM/2018/087", "Shamika Tissera", "shamika", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "IM/2018/000", "Sithum Basnayake", "sithum", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "IM/2018/001", "Malithi Karunarathne", "malithi", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "IM/2018/002", "Pavith Rajapakse", "pavith", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "IM/2018/003", "Kavindu Madhubashana", "kavindu", "1234", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "IM/2018/004", "Tharindu Senanayake", "tharindu", "1234", new ArrayList<>()));


			userService.addRoleToUser("shamika", "ROLE_STUDENT");
			userService.addRoleToUser("sithum", "ROLE_ADMIN");
			userService.addRoleToUser("malithi", "ROLE_ADMIN");
			userService.addRoleToUser("pavith", "ROLE_TEACHER");
			userService.addRoleToUser("kavindu", "ROLE_ADMIN");
			userService.addRoleToUser("tharindu", "ROLE_STUDENT");
		};
	}
}