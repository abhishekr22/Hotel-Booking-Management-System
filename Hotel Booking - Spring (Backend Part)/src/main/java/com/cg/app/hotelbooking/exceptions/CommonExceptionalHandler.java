package com.cg.app.hotelbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionalHandler {
	@ExceptionHandler
	public void handlerForNullPointerException(NullPointerException exp)
	{
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorTemplate> handlerForRatingException(InvalidRatingException exp)
	{
		ErrorTemplate template = new ErrorTemplate();
		template.setErrorMsg(exp.toString());
		template.setActionType("Invalid Rating");
		
		return new ResponseEntity<ErrorTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
}
