package com.UserServices.UserService.Controllers;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UserServices.UserService.Entities.Rating;
import com.UserServices.UserService.Entities.User;
import com.UserServices.UserService.Services.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{	
		User u1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String uid)
	{	
		User u2=userService.getUserbyId(uid);
		
		return ResponseEntity.ok(u2);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/CurrentUser")
	public String getUserDetails(Principal p)
	{
		return p.getName();
	}
}
