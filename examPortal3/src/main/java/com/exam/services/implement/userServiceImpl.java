package com.exam.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.helper.UserFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.repo.roleRepository;
import com.exam.repo.userRepository;
import com.exam.services.UserService;

@Service
@Transactional
public class userServiceImpl implements UserService {

	@Autowired
	private userRepository userRepository;

	@Autowired
	private roleRepository roleRepository;

//	@Override
//	public User createUser(User user, Set<Role> userRoles) throws Exception {
//
//		User local = userRepository.findByuserName(user.getUsername());
//
//		if (local != null) {
//			System.out.println("User already present");
//			throw new UserFoundException();
//		} else {
//			for (Role ur : userRoles) {
//				roleRepository.save(ur);
//			}
//			user.getUserRoles().addAll(userRoles);
//			local = userRepository.save(user);
//		}
//		return local;
//	}

	@Override
	public User createUser(User user) throws Exception {

		User local = userRepository.findByUsername(user.getUsername());

		if (local != null) {
			System.out.println("User already present");
			throw new UserFoundException();
		} else {
			Role ur = new Role();
			ur.setRoleName("user");
			user.getUserRoles().add(ur);
			System.out.println(user);
			local = userRepository.save(user);
//			if (roleRepository.findByroleName(ur.getRoleName()) == null)
//				roleRepository.save(ur);
		}
		return local;
	}

	@Override
	public User getUser(String uname) throws Exception {
//	return userRepository.findByuserName(uname);
		User local = userRepository.findByUsername(uname);

		if (local == null) {
			System.out.println("User not present");
			throw new UserNotFoundException();
		}
		return local;
	}

	@Override
	public User getUserById(Long userId) throws Exception {
		System.out.println("this is service " + userId);
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
	}

	@Override
	public void deleteUser(Long userId) throws Exception {
		if (userRepository.findById(userId).isEmpty()) {
			System.out.println("User not present");
			throw new UserNotFoundException("User not present");
		}

		userRepository.deleteById(userId);
//		return this.userRepository.save(newUser);
	}

	@Override
	public User updateUser(User newUser, Long userId) throws Exception {

		// TODO Auto-generated method stub

		if (userRepository.findById(userId).isEmpty()) {
			System.out.println("User not present");
			throw new UserNotFoundException("User not present");
		}

		return this.userRepository.save(newUser);

	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
