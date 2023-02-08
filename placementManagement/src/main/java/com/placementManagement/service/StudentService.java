package com.placementManagement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementManagement.entity.Student;
import com.placementManagement.repository.StudentRepository;

@Service

public class StudentService {
	
	@Autowired
	private StudentRepository repo;	
	
	public List<Student> listAll()
	{
		return repo.findAll();
	}
	public void addStudent(Student s)	{	
		 repo.save(s);
	}	

	public Student retrieve(Integer id)	{
		return repo.findById(id).get();		
	}
	
	public Student getRecordByRollNo(Integer rollNo)	{
		return repo.findByRollNo(rollNo);		
	}	
	
	public void delete(Integer id)	{
		repo.deleteById(id);
	}	
}
