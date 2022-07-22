package com.exam.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.helper.RoleNotFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.repo.roleRepository;
import com.exam.repo.userRepository;
import com.exam.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private roleRepository roleRepository;
	@Autowired
	private userRepository userRepository;

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
//		log.info("Saving new role {} to the database", role.getName());
		return roleRepository.save(role);
	}

	@Override
	public User addRoleToUser(String username, String roleName) throws Exception {
		// TODO Auto-generated method stub
//		log.info("Adding role {} to user {}", roleName, username);
		System.out.println(username+" "+roleName);
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByroleName(roleName);
		if (user == null)
			throw new UserNotFoundException();
		if (role == null)
			throw new RoleNotFoundException();
		user.getUserRoles().add(role);
		return userRepository.save(user);
	}

}
