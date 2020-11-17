package com.concess.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table
public class VehicleSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   Id;
	
	private String customerNationalId;
	private String concessionaryShortName;
	private String vehiclePlateNumber;
	private String vendorNationalId;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCustomerNationalId() {
		return customerNationalId;
	}
	public void setCustomerNationalId(String customerNationalId) {
		this.customerNationalId = customerNationalId;
	}
	public String getConcessionaryShortName() {
		return concessionaryShortName;
	}
	public void setConcessionaryShortName(String concessionaryShortName) {
		this.concessionaryShortName = concessionaryShortName;
	}
	public String getVehiclePlateNumber() {
		return vehiclePlateNumber;
	}
	public void setVehiclePlateNumber(String vehiclePlateNumber) {
		this.vehiclePlateNumber = vehiclePlateNumber;
	}
	public String getVendorNationalId() {
		return vendorNationalId;
	}
	public void setVendorNationalId(String vendorNationalId) {
		this.vendorNationalId = vendorNationalId;
	}
}
