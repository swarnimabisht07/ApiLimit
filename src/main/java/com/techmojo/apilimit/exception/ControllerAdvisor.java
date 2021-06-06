package com.techmojo.apilimit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalException(){
        return new ResponseEntity<>("Something Went Wrong", HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InvalidStudentId.class)
    public ResponseEntity<Object> invalidStudentIdException(){
        return new ResponseEntity<>("Invalid Student Id", HttpStatus.NOT_FOUND);
    }

}
