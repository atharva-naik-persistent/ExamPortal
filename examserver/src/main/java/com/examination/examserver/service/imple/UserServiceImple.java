package com.examination.examserver.service.imple;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examination.examserver.model.User;
import com.examination.examserver.model.UserRole;
import com.examination.examserver.repo.RoleRepository;
import com.examination.examserver.repo.UserRepository;
import com.examination.examserver.service.UserService;

@Service
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepository usr;
	
	@Autowired
	private RoleRepository rr;
	

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		//check if user already exists
		User local = this.usr.findByUsername(user.getUsername());
		
		if(local !=null) {
			System.out.println("User already exists");
			throw new Exception("User already present!!!");
		}else {
			//create user
			for(UserRole ur: userRoles) {
				rr.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.usr.save(user);
		}
		
		// TODO Auto-generated method stub
		return local;
	}




	//getting user by Username
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.usr.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.usr.deleteById(userId);
	}
	

}
