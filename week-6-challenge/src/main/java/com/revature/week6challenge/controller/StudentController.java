  
package com.revature.week6challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	private StudentService studentService;

	@Autowired // setter injection
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAll() {
		return new ResponseEntity<>(this.studentService.allStudents(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		ResponseEntity<String> resp = null;
		try {
			this.studentService.addStudent(student);
			resp = new ResponseEntity<>("STUDENT CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO CREATE STUDENT", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
		ResponseEntity<String> resp = null;
		try {
			this.studentService.deleteStudent(student);
			resp = new ResponseEntity<>("STUDENT DELETED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO DELETE STUDENT", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}

}
