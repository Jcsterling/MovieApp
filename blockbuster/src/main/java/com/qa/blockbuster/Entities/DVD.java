package com.qa.blockbuster.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "film")
@EntityListeners(AuditingEntityListener.class)
public class DVD implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private String DVDname;
	
	private boolean rented;
	
	private String renteeName;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date rentDate;
	
	
	
	public DVD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DVD(Long id, String dVDname, boolean rented, String renteeName, String description, Date rentDate) {
		super();
		this.id = id;
		DVDname = dVDname;
		this.rented = rented;
		this.renteeName = renteeName;
		this.description = description;
		this.rentDate = rentDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDVDname() {
		return DVDname;
	}

	public void setDVDname(String dVDname) {
		DVDname = dVDname;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public String getRenteeName() {
		return renteeName;
	}

	public void setRenteeName(String renteeName) {
		this.renteeName = renteeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	
	
	
}
