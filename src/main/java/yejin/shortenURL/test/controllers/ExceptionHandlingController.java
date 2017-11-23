package yejin.shortenURL.test.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import yejin.shortenURL.test.commons.BadInputException;
import yejin.shortenURL.test.commons.NotInputException;
import yejin.shortenURL.test.commons.RangeOverException;
import yejin.shortenURL.test.commons.UrlAvailableException;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ResponseBody
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { UrlAvailableException.class})
	public void urlAvailableHandler(RuntimeException ex, WebRequest request){
		System.out.println("errerHandler"+ex.getMessage());
		//TO DO : return "redirect:"+사용자유효성 에러 페이지 ;
		
	}
	
	@ResponseBody
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { NotInputException.class})
	public void notInputHandler(RuntimeException ex, WebRequest request){
		System.out.println("errerHandler"+ex.getMessage());
		//TO DO : return "redirect:"+사용자유효성 에러 페이지 ;
	}
	
	@ResponseBody
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { RangeOverException.class})
	public void rangeOverException(RuntimeException ex, WebRequest request){
		System.out.println("errerHandler"+ex.getMessage());
		//TO DO : return "redirect:"+사용자유효성 에러 페이지 ;
	}
	
	@ResponseBody
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { BadInputException.class})
	public void badInputHandler(RuntimeException ex, WebRequest request){
		System.out.println("errerHandler"+ex.getMessage());
		//TO DO : return "redirect:"+사용자유효성 에러 페이지 ;
	}
	

}
