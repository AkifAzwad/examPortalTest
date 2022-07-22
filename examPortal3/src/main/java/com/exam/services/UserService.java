package com.exam.services;

import java.util.List;

import com.exam.model.User;

public interface UserService {
//    public User createUser(User user, Set<Role> userRoles) throws Exception;
    public User createUser(User user) throws Exception;
    public User getUser(String uname) throws Exception;
    public void deleteUser(Long userId) throws Exception;
    public User updateUser(User user,Long userId) throws Exception;
    public User getUserById(Long uid) throws Exception;
	public List<User> getUsers();
	
}
