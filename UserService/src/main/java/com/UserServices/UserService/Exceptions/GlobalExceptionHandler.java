package com.UserServices.UserService.Exceptions;

import java.util.HashMap;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.Hotel.Hotel_Services.HotelService.Exceptions.ResourceNotFoundException;
import com.UserServices.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private ApiResponse ap;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex)
	{
		Map map= new HashMap();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
		//ApiResponse response=ap.Message(msg).success(true).Status(HttpStatus.NOT_FOUND);
		
		
		}

}
