package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.services.UserService;
import com.exam.services.WeekService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Autowired
	private UserService userService;
	@Autowired
	private WeekService weekService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Project Running");
//        User user=new User();
//        user.setfName("Vaubhav");
//        user.setLname("Agarwal");
//        user.setEmail("agarwalvaibhav041@gmail.com");
//        user.setPassword("ABC@123");
//        user.setUserName("avaibhav54");
//        user.setPhone("7906544082");
//        user.setProfile("default.png");
//
//        Role role = new Role();
//        role.setRoleId(44L);
//        role.setRoleName("ADMIN");
//        Set<userRole> userRoleSet=new HashSet<>();
//        userRole userRole=new userRole();
//        userRole.setRole(role);
//        userRole.setUser(user);
//        userRoleSet.add(userRole);
//        User user1 = this.userService.createUser(user,userRoleSet);
//        System.out.println(user1);
		
		
/////////////////////////////////////////////		
//		User user = new User();
//		user.setUsername("akif");
//		user.setPassword(bCryptPasswordEncoder.encode("1234"));
//		user.setFName("akif");
//		user.setLName("akif");
//		user.setEmail("akif@gmail.com");
//		userService.createUser(user);
	}
}
