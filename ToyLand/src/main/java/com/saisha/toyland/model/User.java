package com.saisha.toyland.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.GenerationType;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String firstname;
	private String lastname;
	
	@NotEmpty(message = "specify appropriate username with 8 characters long")
	@Pattern(regexp="^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9]).{8,}$", message="username must contain atleast 1 upper-case, 1 lower-case and 1 digit")
	private String username;
	
	private String floor;
	private String buildingName;
	private String landmark;
	private String areaName;
	private String city;
	
	@NotEmpty
	@Size(min=6, max=20, message = "mobile contact should be of 10 digits")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "mobile number is expected to start with 7, 8 or 9 only")
	private String contactNumber;
	
	@Column(name = "landline")
	@Size(min=8, max=15, message = "invalied landline number")
	private String landlineNumber;

	@Size(min = 6, max = 6, message = "pincode comprises of 6 digits")
	@Pattern(regexp = "[0-9]{6}")
	private String pincode;
	private String state;

//	@NotNull
//	@Size(min=7, max=50)
//	@Pattern(regexp = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", message = "Entered email id is invalid")
	private String email;
	
	@NotEmpty(message = "password cannot be empty")
	@Size(min = 8, max = 20, message = "password must contains atleast 8 characters")
	@Pattern(regexp="^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message="password should contain atleast 1 upper-case, 1 lower-case, 1 digit and 1 special-character")
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

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
