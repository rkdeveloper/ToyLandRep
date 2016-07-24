package com.saisha.toyland.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product implements Serializable{

	@Id
	@Column(name = "Product_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(name = "Product_Name")
	private String productName;
	
	@Column(name = "Product_Description")
	private String productDescription;
	
	@Column(name= "Stock")
	private int stock;
	
	@Column(name = "Price")
	private int productPrice;
	
	private String manufacturer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	@ManyToOne(fetch=FetchType.LAZY)
	private Supplier supplier;
	
	private static final long serialVersionUID = 1L;
	
	@Transient
	private MultipartFile img;
		
	public Product() {
	}

//	@JoinColumn(name="supplierId", nullable=false)
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

//	@JoinColumn(name="categoryId", nullable=false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	
	public void setStock(int stock){
		this.stock = stock;
	}
	
	public int getStock(){
		return stock;
	}
	
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}
	
	public String toString()
	{
		return "{productId : '" + productId + "', productName : '" + productName + "', productDescription : '" + productDescription + "', productPrice : '" + productPrice + "'}";
	}
}