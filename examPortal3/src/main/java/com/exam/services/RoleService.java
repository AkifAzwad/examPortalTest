package com.exam.services;

import com.exam.model.Role;
import com.exam.model.User;


public interface RoleService {
	 Role saveRole(Role role);
	 User addRoleToUser(String username, String roleName) throws Exception;
}
