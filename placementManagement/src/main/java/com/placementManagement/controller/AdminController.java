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

import com.placementManagement.entity.Admin;
import com.placementManagement.entity.College;
import com.placementManagement.entity.Corporate;
import com.placementManagement.entity.Student;
import com.placementManagement.service.AdminService;
import com.placementManagement.service.CollegeService;
import com.placementManagement.service.CorporateService;


@RestController
@RequestMapping( "/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private CollegeService collegeService;
	
	@Autowired
	private CorporateService corporateService;
	
	//RESTful API
	//creation
	@PostMapping("/admin")
	public String addAdmin(@RequestBody Admin a){
		
		try {
			//calling service method
			service.addAdmin(a);
			return "Admin record inserted";
		}
		catch(Exception e) {
			return "Error occured: "+e.getMessage();
		}
	}
	//deletion
	@DeleteMapping("/admin/{id}")
	public void remove(@PathVariable Integer id)
	{
		service.delete(id);
	}
	//Retrieve with all the records
	@GetMapping("/admin")
	public List<Admin> list()
	{
		return service.listAll();
		
	}
	//Retrieve with specific id
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id)
	{
		try {
			Admin s=service.retrieve(id);
			return new ResponseEntity<Admin>(s,HttpStatus.OK);
		
		}
		catch(NoSuchElementException e)	{
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}		
	}
	//updation	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Admin a, @PathVariable Integer id)
	{
		try {
			System.out.println("inside update method");
			Admin a1=service.retrieve(id);
			
			 service.addAdmin(a);
			 return "record updated";
		
		}
		catch(Exception e)		{
			return "error ocuure"+e.getMessage();
		}
	}
	
	
	//Approve colleges
	@PutMapping("/approve-college/{collegeId}")
	public String approveCollege(@PathVariable Integer collegeId) {
		try {
			College college = collegeService.retrieve(collegeId);
			college.setIsActive(1);
			collegeService.addCollege(college);
			
		} catch(Exception e) {		
			return "Error occurred :"+e.getMessage();
		}
		
		return "College is approved.";
		
	}
	
	
	//Approve colleges
		@PutMapping("/approve-corporate/{corporateId}")
		public String approveCorporate(@PathVariable Integer corporateId  ) {
			try {
				Corporate corporate = corporateService.retrieve(corporateId);
				corporate.setIsActive(1);
				corporateService.create(corporate);
				
			} catch(Exception e) {		
				return "Error occurred :"+e.getMessage();
			}
			
			return "Corporate is approved.";
			
		}
		
	
	
	
	
}