package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.services.RoleService;

import lombok.Data;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping("/create-role")
	@ResponseStatus(HttpStatus.CREATED)
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

	@PostMapping("/role-to-user")
	@ResponseStatus(HttpStatus.OK)
	public User addRoleToUser(@RequestBody RoleToUserForm form) throws Exception {
		return roleService.addRoleToUser(form.getUsername(), form.getRolename());
	}
}

@Data
class RoleToUserForm {
	private String username;
	private String rolename;
}
