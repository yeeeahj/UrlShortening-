package yejin.shortenURL.test.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;


import yejin.shortenURL.test.commons.BadInputException;
import yejin.shortenURL.test.commons.NotInputException;
import yejin.shortenURL.test.commons.RangeOverException;
import yejin.shortenURL.test.commons.UrlAvailableException;
import yejin.shortenURL.test.controllers.responses.DefaultResponse;
import yejin.shortenURL.test.controllers.responses.DefaultResponse.Status;

@ControllerAdvice
public class ExceptionHandlingController {
	
	
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UrlAvailableException.class})
	public @ResponseBody ResponseEntity<DefaultResponse> urlAvailableHandler(RuntimeException ex, WebRequest request){
		System.out.println("Error : "+ex.getMessage());
		DefaultResponse dr = new DefaultResponse(Status.FAIL, ex.getMessage());
		return new ResponseEntity<>(dr, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { NotInputException.class})
	public @ResponseBody ResponseEntity<DefaultResponse> notInputHandler(RuntimeException ex, WebRequest request){
		System.out.println("Error : "+ex.getMessage());
		DefaultResponse dr = new DefaultResponse(Status.FAIL, ex.getMessage());
		return new ResponseEntity<>(dr, HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { RangeOverException.class})
	public @ResponseBody ResponseEntity<DefaultResponse> rangeOverException(RuntimeException ex, WebRequest request){
		System.out.println("Error : "+ex.getMessage());
		DefaultResponse dr = new DefaultResponse(Status.FAIL, ex.getMessage());
		return new ResponseEntity<>(dr, HttpStatus.BAD_REQUEST);
	}
	
	
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { BadInputException.class})
	public  @ResponseBody ResponseEntity<DefaultResponse> badInputHandler(RuntimeException ex, WebRequest request){
		System.out.println("Error : "+ex.getMessage());
		DefaultResponse dr = new DefaultResponse(Status.FAIL, ex.getMessage());
		return new ResponseEntity<>(dr, HttpStatus.BAD_REQUEST);
	}
	

}
