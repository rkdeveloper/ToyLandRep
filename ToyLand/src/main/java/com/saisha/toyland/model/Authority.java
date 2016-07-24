package com.saisha.toyland.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorityId;
	private String roleName;
	
	public int getAuthorityId() {
		return authorityId;
	}
	
	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
