package com.techmojo.apilimit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techmojo.apilimit.exception.InvalidStudentId;
import com.techmojo.apilimit.service.StudentService;

@RestController
@RequestMapping("/apilimit/student")
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;

	
	@GetMapping("/getstudent")
	public ResponseEntity<Object> getStudent(@RequestParam int studentId) throws InvalidStudentId{
		return new ResponseEntity<Object>(studentService.getStudent(studentId),HttpStatus.OK);
		
	}
	
	@GetMapping("/savestudent")
	public ResponseEntity<Object> saveStudent(@RequestParam String studentName){
		return new ResponseEntity<Object>(studentService.saveStudent(studentName),HttpStatus.OK);
		
	}
	
	
	
	
}
