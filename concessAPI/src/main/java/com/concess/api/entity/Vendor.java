package com.concess.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   Id;
	
	private String nationalId;
	
	private String fullName;
	
	private String concessionary;
	
	public Long getId() {
		return Id;
	}
	public String getNationalId() {
		return nationalId;
	}
	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getConcessionary() {
		return concessionary;
	}
	public void setConcessionary(String concessionary) {
		this.concessionary = concessionary;
	}
}
