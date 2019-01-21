package com.qa.blockbuster.Services;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.qa.blockbuster.Entities.DVD;
import com.qa.blockbuster.Exceptions.ResourceNotFoundException;
import com.qa.blockbuster.Repositories.DVDRepository;


@Service
public class DVDService {
	
	@Autowired
	private DVDRepository DVDRepo; 
	
	
	
	 public List<DVD> getAllDVDs(){
		 
		return DVDRepo.findAll();
	 }
	 
	 
	 public void addDVD (DVD dvd) {
		 DVDRepo.save(dvd);
	 }
	  
	
	 public void deleteDVD(Long id) {
		 DVDRepo.deleteById(id);
	 }
			 
	 public void getDVD(Long id) {
		 DVDRepo.findById(id);
	 }


}
