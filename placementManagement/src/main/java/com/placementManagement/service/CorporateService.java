package com.placementManagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementManagement.entity.College;
import com.placementManagement.entity.Corporate;
import com.placementManagement.entity.Student;
import com.placementManagement.repository.CollegeRepository;
import com.placementManagement.repository.CorporateRepository;
import com.placementManagement.repository.StudentRepository;


@Service
@Transactional
public class CorporateService {
	
	@Autowired
	private CorporateRepository repo;
	
	@Autowired
	StudentRepository studRepo;
	
	@Autowired
	CollegeRepository collegeRepository;
	
	//to retrieve all the data of student class
	public List<Corporate> listAll()
	{
		return repo.findAll();
	}
	//insert/create/update a data
	public void create(Corporate s)
	{
		 repo.save(s);
	}
	//to retrieve a single record
	public Corporate retrieve(Integer id)
	{
		return repo.findById(id).get();
		
	}
	//to delete a data
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}

	public List<Student> getAllStudents(){
			
			return studRepo.findAll();
		}
	
		public Student getStudentByRollNo(Integer id){
			
			return studRepo.findByRollNo(id);
			
		}
		
		
//	public Student getStudentByCertId(Integer CertId){
//			
//			return studRepo.findByCertId(CertId);
//			
//		}
	public List<Student> getAllStudentsByCollegeId(Integer collegeId){
		
		//return studRepo.findByCollegeId(collegeId);
		return null;
	}
	
	//to retrieve a single record
	public College getCollegeById(Integer college_id){
		return collegeRepository.findById(college_id).get();
		
	}
	public List<College> getAllColleges()	{
		return collegeRepository.findAll();
	}
}
