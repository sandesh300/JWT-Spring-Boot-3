package com.jwt.example;

import com.jwt.example.model.Role;
import com.jwt.example.model.User;
import com.jwt.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtExample3Application 
{
   @Autowired
   private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(JwtExample3Application.class, args);

	}
	public void run(String... run) {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
        if(null == adminAccount){
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);
		}
	}
	}


