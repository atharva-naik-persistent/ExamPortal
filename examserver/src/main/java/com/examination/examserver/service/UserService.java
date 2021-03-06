package com.examination.examserver.service;

import java.util.Set;

import com.examination.examserver.model.User;
import com.examination.examserver.model.UserRole;

public interface UserService {
	
	//for creating user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	//for getting user by his username
	public User getUser(String username);
	
	//for deleteing user by id
	public void deleteUser(Long userId);

}
