package com.placementManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementManagement.entity.College;
import com.placementManagement.entity.Placement;
import com.placementManagement.entity.Student;
import com.placementManagement.repository.CollegeRepository;
import com.placementManagement.repository.PlacementRepository;
import com.placementManagement.repository.StudentRepository;



@Service
@Transactional
public class CollegeService {
	@Autowired
	private CollegeRepository repo;
	
	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	PlacementRepository placementRepo;
	
	//to retrieve all the data of college class
	public List<College> listAll()
	{
		return repo.findAll();
	}

	//insert/create a data
	public void addCollege(College c){
		repo.save(c);
	}
	
	//to retrieve a single record
	public College retrieve(Integer college_id)
	{
		return repo.findById(college_id).get();
		
	}
	
	//to delete a data
	public void delete(Integer college_id)
	{
		repo.deleteById(college_id);
	}
	public void addStudent(Student s)
	{
		 studRepo.save(s);
	}
	
	public void addPlacement(Placement p)
	{
		 placementRepo.save(p);
	}
	
	public List<Student> getAllStudents(){
		
		return studRepo.findAll();
	}
	public Student getStudentByRollNo(Integer rollNo){
		
		return studRepo.findByRollNo(rollNo);
		
	}
}
