package com.saisha.toyland.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "Category_ID")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int categoryId;
	@Column(name = "Category_Name")
	private String categoryName;
	@Column(name = "Category_Description")
	private String categoryDescription;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
//	private Set<Product> productSet = new HashSet<Product>(0);
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryDescription() {
		return categoryDescription;
	}
	
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

/*	public Set<Product> getProductSet() {
		return productSet;
	}

	public void setProductSet(Set<Product> productSet) {
		this.productSet = productSet;
	}*/
}