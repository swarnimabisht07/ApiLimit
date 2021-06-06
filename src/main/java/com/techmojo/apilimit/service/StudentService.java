package com.techmojo.apilimit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techmojo.apilimit.beans.Student;
import com.techmojo.apilimit.dao.StudentDAO;
import com.techmojo.apilimit.exception.InvalidStudentId;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public Student getStudent(int studentId) throws InvalidStudentId {
		Optional<Student> student=studentDAO.findById(studentId);
		if(student.isEmpty()) {
			throw new InvalidStudentId();
		}
		return student.get();
	}

	public Student saveStudent(String studentName) {
		Student student = new Student();
		student.setStudentName(studentName);
		return studentDAO.save(student);
	}

}
