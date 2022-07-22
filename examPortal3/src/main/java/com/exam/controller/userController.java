package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.User;
import com.exam.repo.userRepository;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class userController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserService userService;
	@Autowired
	private userRepository userRepository;
	
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) throws Exception {
		System.out.println(user);
		user.setProfile("default.png");
		String pass = user.getPassword();
		if(pass==null)pass="1234";
		user.setPassword(bCryptPasswordEncoder.encode(pass));
		return userService.createUser(user);
	}

	@GetMapping("/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public User getUser(@PathVariable("userId") Long uid) throws Exception {
		System.out.println(uid);
		User x = new User();
		return userService.getUserById(uid);
	}
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUser() throws Exception {
		return userService.getUsers();
	}

	@PutMapping("/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public User updateUser(@RequestBody User user, @PathVariable("userId") Long uid) throws Exception {
		System.out.println(uid);
		
		return userService.updateUser(user, uid);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable("userId") Long uid) throws Exception {
		System.out.println(uid);
		userService.deleteUser(uid);
	}
	
	
	
}





