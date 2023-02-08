package com.placementManagement.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementManagement.entity.College;
import com.placementManagement.entity.Corporate;
import com.placementManagement.entity.Student;
import com.placementManagement.service.CorporateService;


@RestController
@RequestMapping( "/corporate")
public class CorporateController {
	
	@Autowired
	private CorporateService service;
	
	//RESTful API
	//creation
	@PostMapping("/add")
	public void add(@RequestBody Corporate u)
	{
		service.create(u);
	}
	//deletion
	@DeleteMapping("/delete/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/getAllRecords")
	public List<Corporate>list()
	{
		return service.listAll();
		
	}
	//Retrieve with specific id
	@GetMapping("/getRecordById/{id}")
	public ResponseEntity<Corporate> get(@PathVariable Integer id)
	{
		try {
			Corporate u=service.retrieve(id);
			return new ResponseEntity<Corporate>(u,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Corporate>(HttpStatus.NOT_FOUND);
		}
		
	}
	//updation
	@PutMapping("/update/{id}")
	public String update(@RequestBody Corporate u, @PathVariable Integer id)
	{
		try {
			@SuppressWarnings("unused")
			Corporate u1=service.retrieve(id);
			service.create(u);
			 return "record updated";
		
		}
		catch(NoSuchElementException e)
		{
			return "error ocuure"+e.getMessage();
		}
		
	}
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return service.getAllStudents();
		
	}
	//Retrieve with specific id
	@GetMapping("/studentByRollNo/{rollNo}")
	public Student getStudentByRollNo(@PathVariable Integer rollNo)
	{
		Student stud =null;
		try {
			stud=service.getStudentByRollNo(rollNo);
			
		
		}
		catch(NoSuchElementException e){
			System.out.println("error occurd"+e.getMessage());
			
		}
		return stud;
		
	}
	
//	@GetMapping("/studentByCertId/{certId}")
//	public Student getStudentByCertId(@PathVariable Integer certId)
//	{
//		Student stud =null;
//		try {
//			stud=service.getStudentByCertId(certId);
//			
//		
//		}
//		catch(NoSuchElementException e){
//			System.out.println("error occurd"+e.getMessage());
//			
//		}
//		return stud;
//		
//	}
	@GetMapping("/studentsByCollegeId/{collegeId}")
	public List<Student> getAllStudentsByCollegeId(Integer collegeId){
		
		return service.getAllStudentsByCollegeId(collegeId);
		
	}
	
	
	//Get all the colleges
	@GetMapping("/colleges")
	public List<College> getAllColleges()	{
		return service.getAllColleges();
		
	}
	
	
	@GetMapping("/college/{college_id}")
	public College getCollegeById(@PathVariable Integer college_id) {
		College clg = null;
		try {
		    clg = service.getCollegeById(college_id);			
		}
		catch(NoSuchElementException e){
			System.out.println("Error Occured : "+e.getMessage());
		}
		return clg;
	}
	
		

}
