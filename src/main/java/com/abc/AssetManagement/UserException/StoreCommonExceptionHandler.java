package com.abc.AssetManagement.UserException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StoreCommonExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<MyUserExceptionResponse> handleUnAuthorizedUserException(InvalidUserException e)
	{
		MyUserExceptionResponse excResponse = new MyUserExceptionResponse();
		
		excResponse.setNow(LocalDateTime.now());
		excResponse.setUsername(e.getUsername());
		excResponse.setErrorMsg(e.getUsername()+" and "+e.passwordCoverter()+" not present in the DB");// replace from Session Tracking 
		
		excResponse.setExceptionCause("username password doesn't match Please Register");
		
		return new ResponseEntity<MyUserExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<MyUserExceptionResponse> handleUnAuthorizedUserException(WrongUserOrPasswordException w)
	{
		MyUserExceptionResponse excResponse = new MyUserExceptionResponse();
		
		excResponse.setNow(LocalDateTime.now());
		excResponse.setUsername(w.getUsername());
		excResponse.setErrorMsg(w.getUsername()+" and "+w.passwordCoverter()+" not present in the DB");// replace from Session Tracking 
		
		excResponse.setExceptionCause("username password doesn't match");
		
		return new ResponseEntity<MyUserExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
	}
	

}