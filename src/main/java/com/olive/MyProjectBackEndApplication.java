package com.olive;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.olive.config.SecurityUtility;
import com.olive.domain.User;
import com.olive.domain.security.Role;
import com.olive.domain.security.UserRole;
import com.olive.service.UserService;

@SpringBootApplication
@ComponentScan(basePackages = {"com.olive"})
public class MyProjectBackEndApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//    private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(MyProjectBackEndApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
//		String[] beans = appContext.getBeanDefinitionNames();
//        Arrays.sort(beans);
//        for (String bean : beans) {
//            System.out.println(bean);
//        }
//        System.out.println("=============JAVA 8===========");
//        Arrays.asList(appContext.getBeanDefinitionNames()).stream().sorted().forEach(System.out::println);

        
		User user1 = new User();
		user1.setFirstName("test");
		user1.setLastName("test");
		user1.setUsername("test");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("test"));
		user1.setEmail("test@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("Admin@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
	}
	
}
