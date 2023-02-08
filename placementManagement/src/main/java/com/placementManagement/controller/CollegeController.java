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
import com.placementManagement.entity.Placement;
import com.placementManagement.entity.Student;
import com.placementManagement.service.CollegeService;

@RestController
@RequestMapping( "/college")
public class CollegeController {
	
	@Autowired
	private CollegeService service;
	
	//Add a college
	@PostMapping("/add")
	public String addCollege(@RequestBody College c) {		
		try {
			//calling service method
			service.addCollege(c);
			return "Student record inserted";
		}
		catch(Exception e) {
			return "Error occured: "+e.getMessage();
		}
	}	

	//Get All Colleges
	@GetMapping("/getAllColleges")
	public List<College> getAllColleges(){ 
		List<College> res = null;
		try {
			res = service.listAll();
		}
		catch(Exception e) {
			System.out.println("Error Occured : "+e.getMessage());
		}
		return res;
		
	}
		
	//retrieve with college id
	@GetMapping("/collegeId/{college_id}")
	public College getCollegeById(@PathVariable Integer college_id){  
		College college = null;
		try {
				college = service.retrieve(college_id);
		}
		catch(NoSuchElementException e)	{
			System.out.println("Error occured : "+e.getMessage());
		}
		return college;
	}
	
	//Update record based on college id.
	@PutMapping("/update/{college_id}")
	public String updateCollege(@RequestBody College college, @PathVariable Integer college_id)
	{   
		try {
			System.out.println("inside update method");
			service.retrieve(college_id);			
		 	service.addCollege(college);
		 	return "record updated";		
		}
		catch(Exception e){
			return "error ocuured"+e.getMessage();
		}
	}
	
	//Delete a college	
	@DeleteMapping("/delete/{college_id}")
	public String removeCollege(@PathVariable Integer college_id){
		service.delete(college_id);
		return "Record deleted.";
	}	
	
	/*
	 * Operations for student entity
	 * 1.College can add a student record.
	 * 2.College can schedule a placement drive.
	 * 3.Search student records.
	 */
	
	//add student records
	@PostMapping("/add-student")
	public String addStudent(@RequestBody Student student){
		try {
			//calling service method
			service.addStudent(student);
			return "Student record inserted";
		}
		catch(Exception e) {
			return "Error occured: "+e.getMessage();
		}
	}
	
	//Create/add placement record/drive.
	@PostMapping("/placement")
	public String add(@RequestBody Placement p){
		try {
			//calling service method
			service.addPlacement(p);
			return "Placement record inserted";
		}
		catch(Exception e) {
			return "Error occured: "+e.getMessage();
		}
	}
	

	//Get all the students record
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return service.getAllStudents();
		
	}
	
	//Retrieve the student record based on roll no
	@GetMapping("/student/{rollNo}")
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
	

}
