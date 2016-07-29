package com.saisha.toyland.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Supplier implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierId;
	
	@NotEmpty(message = "Please enter supplier name")
	private String supplierName;
	
	@NotEmpty(message = "Contact person is compulsary")
	private String contactPerson;
	
	private int contactNumber;
	@NotEmpty(message = "Floor Detail is compulsary")
	private String floor;
	private String buildingName;
	private String areaName;
	private String city;
	private int pincode;
	private String state;
	private static final long serialVersionUID = 1L;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="supplier")
//	private Set<Product> productSet = new HashSet<Product>(0);
	
	public int getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public int getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="supplier")
//	public Set<Product> getProductSet() {
//		return productSet;
//	}
//
//	public void setProductSet(Set<Product> productSet) {
//		this.productSet = productSet;
//	}
	
}