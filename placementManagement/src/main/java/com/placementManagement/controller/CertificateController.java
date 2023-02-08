package com.placementManagement.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placementManagement.entity.Certificate;
import com.placementManagement.service.CertificateService;



@RestController
@CrossOrigin("*")
@RequestMapping("certificate")
public class CertificateController {
	@Autowired
	private CertificateService service;
	//RESTFUL API method for Create operation
	@PostMapping("/add")
	public String addCertificate(@RequestBody Certificate c){
		
		
		try {
			//calling service method
			service.addCertificate(c);
			return "certificate record inserted";
		}
		catch(Exception e) {
			return "Error occured: "+e.getMessage();
		}
	}

	
	//RESTFUL API method for retrieve operation
	@GetMapping("/getCertificateById/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Integer id)
	{
		try
		{			
			Certificate s =service.retrieve(id);
			return new ResponseEntity<Certificate>(s,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	//RESTFUL API method for retrieveAll operation
	@GetMapping("/getAllCertificates")
	public List<Certificate>listAll()	{
		return service.retrieveAll();
	}

	//RESTFUL API method for delete operation
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable Integer id){
		service.delete(id);
		return "Certificate deleted";
	}
		
		
	//RESTFUL API method for update operation
	@PutMapping("/update/{id}")
	public String update(@RequestBody Certificate c,@PathVariable Integer id)
	{
		try
		{
			System.out.println("inside update method");
			Certificate existObject=service.retrieve(id);
			service.addCertificate(c);
			return "record updated";
			
		}
		catch(NoSuchElementException e)
		{
			return "error ocuure"+e.getMessage();
		}
		
	}

}

