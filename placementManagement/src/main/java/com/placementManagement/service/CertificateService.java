package com.placementManagement.service;
import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementManagement.entity.Certificate;
import com.placementManagement.repository.CertificateRepository;



@Service
@TransactionScoped
public class CertificateService {
	
	@Autowired // to inject object dependency
	private CertificateRepository repo;
	
	public void addCertificate(Certificate c)
	{
		repo.save(c);
	}
	//
	public Certificate retrieve(Integer id)
	{
		return repo.findById(id).get();
	}
	//
	public List<Certificate>retrieveAll()
	{
		return repo.findAll();
	}
	//
	public void delete(Integer id)
	{
		repo.deleteById(id);
	}

}