package com.qa.blockbuster.Controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.blockbuster.Entities.DVD;
import com.qa.blockbuster.Exceptions.ResourceNotFoundException;
import com.qa.blockbuster.Repositories.DVDRepository;
import com.qa.blockbuster.Services.DVDService;

@RestController
public class DVDController {
	
	@Autowired
	DVDRepository FilmRepo;
	
	@Autowired
	DVDService Filmserve;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/film")
	public List<DVD> getDVDs() {
		return Filmserve.getAllDVDs();
	}
	
	@PostMapping("/film")
	public void addDVD(@RequestBody DVD dvd) {
		
		Filmserve.addDVD(dvd);
		
		
	}
	@PutMapping("/film/{id}")
	public DVD updateDVDS(@PathVariable(value = "id") Long DVDID, @Valid @RequestBody DVD DVDDetails) {
	
		DVD dvd = FilmRepo.findById(DVDID).orElseThrow(() -> new ResourceNotFoundException("DVD", "id", DVDID));
		
		dvd.setDVDname(DVDDetails.getDVDname());
		dvd.setRentDate(DVDDetails.getRentDate());
		dvd.setRenteeName(DVDDetails.getRenteeName());
		dvd.setDescription(DVDDetails.getDescription());
		dvd.setRented(DVDDetails.isRented());
		
		if(dvd.isRented() == true) {
			if (dvd.getRentDate() == null) { 
				dvd.setRentDate(new Date());
			}
		}
		
		DVD updateData = FilmRepo.save(dvd);
		
		return updateData;
	}
	
	
	
  
	@DeleteMapping
	public void deleteSpecificDVD(Long id) {
		 Filmserve.deleteDVD(id);
		 
	}
	
	@GetMapping("/film/{id}")
	public void getSpecificDVD(Long id) {
		 Filmserve.getDVD(id);
		 
	}
		
	
	

}
