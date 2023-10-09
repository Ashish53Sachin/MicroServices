package com.UserServices.UserService.payload;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Configuration
public class ApiResponse {
	private String message;
	private boolean success;
	private HttpStatus status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public ApiResponse(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", success=" + success + ", status=" + status + "]";
	}
	

}
