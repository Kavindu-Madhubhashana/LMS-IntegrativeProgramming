package lk.ac.kln.lms;

import lk.ac.kln.lms.domain.AppUser;
import lk.ac.kln.lms.domain.CourseCategory;
import lk.ac.kln.lms.domain.Role;
import lk.ac.kln.lms.dto.CreateCourseCategoryDto;
import lk.ac.kln.lms.dto.CreateCourseDto;
import lk.ac.kln.lms.dto.RegisterUserDto;
import lk.ac.kln.lms.enums.RoleEnum;
import lk.ac.kln.lms.service.AppUserService;
import lk.ac.kln.lms.service.CourseCategoryService;
import lk.ac.kln.lms.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(AppUserService userService, CourseCategoryService courseCategoryService, CourseService courseService) {
		return args -> {
			userService.saveRole(new Role(null, RoleEnum.ROLE_STUDENT));
			userService.saveRole(new Role(null, RoleEnum.ROLE_TEACHER));
			userService.saveRole(new Role(null, RoleEnum.ROLE_ADMIN));

			List<RoleEnum> studentRoles = new ArrayList<>();
			studentRoles.add(RoleEnum.ROLE_STUDENT);

			List<RoleEnum> teacherWithAdminRole = new ArrayList<>();
			teacherWithAdminRole.add(RoleEnum.ROLE_ADMIN);
			teacherWithAdminRole.add(RoleEnum.ROLE_TEACHER);

			List<RoleEnum> adminRole = new ArrayList<>();
			adminRole.add(RoleEnum.ROLE_ADMIN);

			List<RoleEnum> teacherRole = new ArrayList<>();
			teacherRole.add(RoleEnum.ROLE_TEACHER);

			userService.saveUser(new RegisterUserDto( "IM/2018/087", "Shamika Tissera", "shamika", "1234","shamika@gmail.com", studentRoles));
//			userService.saveUser(new RegisterUserDto("IM/2018/000", "Sithum Basnayake", "sithum", "1234","sithum@gmail.com", teacherRole));
//			userService.saveUser(new RegisterUserDto("IM/2018/001", "Malithi Karunarathne", "malithi", "1234","malithi@gmail.com", teacherWithAdminRole));
//			userService.saveUser(new RegisterUserDto("IM/2018/002", "Pavith Rajapakse", "pavith", "1234", "pavith@gmail.com", adminRole));
//			userService.saveUser(new RegisterUserDto( "IM/2018/003", "Kavindu Madhubashana", "kavindu", "1234", "kavindu@gmail.com", studentRoles));
//			userService.saveUser(new RegisterUserDto( "IM/2018/004", "Tharindu Senanayake", "tharindu", "1234", "tharindu@gmail.com", adminRole));

			Optional<CourseCategory> IT = courseCategoryService.saveCourseCategory(new CreateCourseCategoryDto("IT"));
			courseCategoryService.saveCourseCategory(new CreateCourseCategoryDto("MGMT"));
			courseCategoryService.saveCourseCategory(new CreateCourseCategoryDto("Science"));
			courseCategoryService.saveCourseCategory(new CreateCourseCategoryDto("Maths"));

			courseService.saveCourse(new CreateCourseDto("MGMT31222", "Managerial Finance", "Most loved course from IM Departmenet", Date.valueOf("2023-01-12"), Date.valueOf("2023-10-22"), IT.get().getId() ));

		};
	}
}