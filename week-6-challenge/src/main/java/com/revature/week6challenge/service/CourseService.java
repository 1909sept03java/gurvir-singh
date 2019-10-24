package com.revature.week6challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.week6challenge.model.Course;
import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.repository.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> allCourses() {
		return this.courseRepository.findAll();
	}

	public Course getCourseById(int id) {
		return this.courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course c) {
		this.courseRepository.save(c);
	}
	
	public List<Student> allStudentsInCourse(int id) {
		Course c = this.courseRepository.findById(id).orElse(null);
		List<Student> allStudents = c.getStudents();
	    return allStudents;
		
	}
	
	public void addStudentToCourse(Student s, int id) {
		List<Student> allStudents = allStudentsInCourse(id);
		allStudents.add(s);
		Course c = this.courseRepository.findById(id).orElse(null);
		c.setStudents(allStudents);
		this.courseRepository.save(c);
		
		
	}
	
	public List<Course> allCoursesByStudentId(int id) {
		List<Course> c = this.courseRepository.findAll();
		List<Course> studentC = new ArrayList<>();
		for(Course course: c) {
			for(Student s: course.getStudents()) {
				if(s.getId() == id) {
					studentC.add(course);
				}
			}
		}
		
		return studentC;
	}
	
	
	
}