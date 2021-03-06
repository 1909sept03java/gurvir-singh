package com.revature.week6challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.week6challenge.model.Student;
import com.revature.week6challenge.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> allStudents() {
		return this.studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		return this.studentRepository.findById(id).orElse(null);
	}

	public void addStudent(Student s) {
		this.studentRepository.save(s);
	}
	
	public void deleteStudent(Student s) {
		this.studentRepository.delete(s);
	}

}
