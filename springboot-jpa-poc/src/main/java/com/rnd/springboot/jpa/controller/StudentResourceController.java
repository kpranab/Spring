/**
 * 
 */
package com.rnd.springboot.jpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/getAllStudents")
	public List<Student> retrieveAllStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/getStudent")
	public Student retrieveStudent(@PathVariable long id) throws StudentNotFoundException{
		Optional<Student> student = studentRepository.findById(id);
		if(!student.isPresent())
			throw new StudentNotFoundException("id : "+id);
		return student.get();
	}
	
	@GetMapping("/createStudent")
	public List<Student> createStudent(){
		
		Student student1 = studentRepository.save(new Student("Saroj", "S4514D"));
		Student student2 = studentRepository.save(new Student("Pranab", "P3214K"));
		Student student3 = studentRepository.save(new Student("Brahma", "B7614S"));
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		return studentList;
	}

}
