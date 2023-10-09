package com.UserServices.UserService.Services;

import java.util.List;

import com.UserServices.UserService.Entities.User;

public interface UserService {
	
	User saveUser(User u1);
	
	List<User> getAllUser();
	
	User getUserbyId(String userId);

}
