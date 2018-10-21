/**
 * 
 */
package com.rnd.springboot.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rnd.springboot.jpa.entity.Student;
import com.rnd.springboot.jpa.exception.StudentNotFoundException;
import com.rnd.springboot.jpa.repo.StudentRepository;

/**
 * @author Pranab Kumar Sahoo
 *
 */
@RestController
public class StudentResourceController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> retrieveAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student retrieveStudent(@PathVariable long id) throws StudentNotFoundException{
		Optional<Student> student = studentRepository.findById(id);
		if(!student.isPresent())
			throw new StudentNotFoundException("id : "+id);
		return student.get();
	}

}
