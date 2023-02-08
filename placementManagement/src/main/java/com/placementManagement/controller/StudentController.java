package com.placementManagement.controller;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementManagement.entity.Student;
import com.placementManagement.service.StudentService;


@RestController
@CrossOrigin("*")
@RequestMapping( "/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	

	//Add a student record
	@PostMapping(value = "/add")
	public String addStudent(@RequestBody Student student){
		try {
			System.out.println("Inside controller");
			//calling service method
			service.addStudent(student);
			return "Student record inserted";
		}
		catch(Exception e) {
			return "Error occured: "+e.getMessage();
		}
	}	

	//Retrieve with all the records
	@GetMapping("/getAllRecord")
	public List<Student>list() 	{
		List<Student> stud = null;
		try {
			stud = service.listAll();
		}
		catch(Exception e) {
			System.out.println("Error occured : "+e.getMessage());
		}
	return stud;		
	}
	
	//Retrieve with specific id
	@GetMapping("/getRecord/{id}")
	public Student getRecordById(@PathVariable Integer id) {
		Student stud = null;
		try {
			stud = service.retrieve(id);			
		
		}
		catch(NoSuchElementException e)	{
			System.out.println("Error occured : "+e.getMessage());
		}		
		return stud;
		
	}
	
	//Retrieve with specific id
	@GetMapping("/getRecordByRollNo/{rollNo}")
	public Student getRecordByRollNo(@PathVariable Integer rollNo) {
		Student stud = null;
		try {
			stud = service.getRecordByRollNo(rollNo);
		}
		catch(NoSuchElementException e)	{
			System.out.println("Error occured : "+e.getMessage());				
		}		
		return stud;
	}
	
	//updation of a student record.
	@PutMapping("/update/{id}")
	public String update(@RequestBody Student s, @PathVariable Integer id)
	{			
		try {
			System.out.println("inside update method");
			Student s1=service.retrieve(id);			
			 service.addStudent(s);
			 return "record updated";		
		}
		catch(Exception e)	{
			return "error ocuure"+e.getMessage();
		}		
	}
	
	
	@DeleteMapping("/deleteRecord/{id}")
	public String remove(@PathVariable Integer id)
	{
		try {
			service.delete(id);
			return "Record deleted";
		}
		catch(Exception e) {
			return "Error occured : "+e.getMessage();
		}
	}
	
}