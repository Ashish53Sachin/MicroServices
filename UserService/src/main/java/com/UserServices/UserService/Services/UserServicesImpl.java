package com.UserServices.UserService.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.UserServices.UserService.Entities.Rating;
import com.UserServices.UserService.Entities.User;
import com.UserServices.UserService.Exceptions.ResourceNotFoundException;
import com.UserServices.UserService.Repositories.UserRepository;

@Service
public class UserServicesImpl implements UserService{

	@Autowired
	private RestTemplate rst;

	@Autowired
	private UserRepository userRepository;
	
	private Logger logger= LoggerFactory.getLogger(UserServicesImpl.class);

	@Override
	public User saveUser(User u1) {
		// TODO Auto-generated method stub
		String randomUserId= UUID.randomUUID().toString();
		u1.setUserId(randomUserId);
		return userRepository.save(u1);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
//		Optional<ArrayList> allUsers= Optional.ofNullable(rst.getForObject("http://localhost:9908/ratings/users/"+userId, ArrayList.class));
//		if (op.isPresent()) {
//		logger.info("{}", op);
//		}
//		else {
//			System.out.println("No object found !!");
//		}
//		user.setRatings(object);
		
		return userRepository.findAll();
	}

	@Override
	public User getUserbyId(String userId) {
		// TODO Auto-generated method stub
		User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on Erver !!"+ userId));
		//ArrayList object=rst.getForEntity("http://localhost:9908/ratings/users/6f4d7b77-3712-407c-ba9e-2f9629e0a054",ArrayList.class));
		ArrayList object=rst.getForObject("http://localhost:9908/ratings/users/"+user.getUserId(), ArrayList.class);
		Optional<ArrayList> op= Optional.ofNullable(rst.getForObject("http://localhost:9908/ratings/users/"+userId, ArrayList.class));
		if (op.isPresent()) {
		logger.info("{}", op);
		}
		else {
			System.out.println("No object found !!");
		}
		user.setRatings(object);
		return user;
	}

}
