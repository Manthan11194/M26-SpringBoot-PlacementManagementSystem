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

import com.placementManagement.entity.Placement;
import com.placementManagement.service.PlacementService;

@RestController
@RequestMapping( "/placement")
public class PlacementController {
	@Autowired
	private PlacementService service;
	
	
	//RESTful API
		//creation
		@PostMapping("/add")
		public String add(@RequestBody Placement p){
			try {
				//calling service method
				service.addPlacement(p);
				return "Placememt record inserted";
			}
			catch(Exception e) {
				return "Error occured: "+e.getMessage();
			}
		}
		//deletion
		@DeleteMapping("/delete/{id}")
		public void remove(@PathVariable Integer id)
		{
			service.delete(id);
		}
		//Retrieve with all the records
		@GetMapping("/getAllRecords")
		public List<Placement>list()
		{
			return service.listAll();
			
		}
		//Retrieve with specific id
		@GetMapping("/getPlacemenetDetailById/{id}")
		public ResponseEntity<Placement> get(@PathVariable Integer id)
		{
			try {
				Placement p=service.retrieve(id);
				return new ResponseEntity<Placement>(p,HttpStatus.OK);
			
			}
			catch(NoSuchElementException e)
			{
				return new ResponseEntity<Placement>(HttpStatus.NOT_FOUND);
			}
			
			
		}
		//updation
		@PutMapping("/update/{id}")
		public String update(@RequestBody Placement p, @PathVariable Integer id)
		{
			try {
				
				System.out.println("inside update method");
				Placement p1=service.retrieve(id);
				service.addPlacement(p);
				return "record updated";
			
			}
			catch(NoSuchElementException e)
			{
				return "error ocuure"+e.getMessage();
			}
			
			
		}
}

