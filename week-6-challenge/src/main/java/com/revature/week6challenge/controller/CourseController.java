  
package com.revature.week6challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.week6challenge.model.Course;
import com.revature.week6challenge.model.SCourse;
import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.service.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	private CourseService courseService;

	@Autowired // setter injection
	public void setStudentService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getAll() {
		return new ResponseEntity<>(this.courseService.allCourses(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentCourses", method = RequestMethod.GET)
	public ResponseEntity<List<Course>> allCoursesByStudentId(@RequestParam int id) {
		return new ResponseEntity<>(this.courseService.allCoursesByStudentId(id), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody Course course) {
		ResponseEntity<String> resp = null;
		try {
			this.courseService.addCourse(course);
			resp = new ResponseEntity<>("COURSE CREATED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>("FAILED TO CREATE COURSE", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> addStudentToCourse(@RequestBody SCourse sc) {
		Student student = new Student(sc.getId(), sc.getName());
		int id = sc.getcId();
		ResponseEntity<String> resp = null;
		System.out.println(id);
		try {
			this.courseService.addStudentToCourse(student, id);
			resp = new ResponseEntity<>("STUDENT ADDED SUCCESSFULLY", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(sc);
			resp = new ResponseEntity<>("FAILED TO ADD STUDENT", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
		
	}
	
    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
	
}
	

