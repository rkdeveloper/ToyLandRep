package com.saisha.toyland.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GenerationType;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String firstname;
	private String lastname;
	private String username;
	
	private String floor;
	private String buildingName;
	private String landmark;
	private String areaName;
	private String city;
	
//	@NotEmpty
//	@Size(min=6, max=20, message = "mobile contact should be of 10 digits")
//	@Pattern(regexp = "[7-9][0-9]{9}", message = "mobile number is expected to start with 7, 8 or 9 only")
	private String contactNumber;
	
//	@NotNull
//	@Max(value=6)
	private int pincode;
	private String state;
	
//	@NotEmpty
//	@Email
	private String email;
	
//	@NotEmpty
//	@Size(min = 6, max = 15, message = "password must contain atleast 6 characters and maximum 15 characters")
	private String password;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	public String getUserid(){
		return userid;
	}
	
//	@JoinColumn(name="authorityId", nullable=false)
	private Authority authority;
	
	public void setUserid(String userid){
		this.userid = userid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
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

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	
	public String getContactNumber(){
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber){
		this.contactNumber = contactNumber;
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
}
