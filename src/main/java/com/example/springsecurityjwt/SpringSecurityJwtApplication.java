package com.example.springsecurityjwt;

import com.example.springsecurityjwt.entity.Role;
import com.example.springsecurityjwt.entity.User;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(1L, "ROLE_USER"));
			userService.saveRole(new Role(2L, "ROLE_MANAGER"));
			userService.saveRole(new Role(3L, "ROLE_ADMIN"));

			userService.save(new User(1L, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.save(new User(2L, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.save(new User(3L, "Will Smith", "Will", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("jim", "ROLE_MANAGER");
			userService.addRoleToUser("Will", "ROLE_ADMIN");
			userService.addRoleToUser("Will", "ROLE_MANAGER");
			userService.addRoleToUser("Will", "ROLE_USER");
		};
	}


}
