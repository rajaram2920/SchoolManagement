package com.example.demo.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;
	
	//retrieve
	public List<Student> listAll() {	
		return repo.findAll();	
	}
	
	//update
	public Student get(long id) {		
		return repo.findById(id).get();
	}
	
	//delete
	public void delete(long id) {	
		repo.deleteById(id);		
	}
	
	//store
	public void save(Student std) {
		repo.save(std);
	}	
	
}
