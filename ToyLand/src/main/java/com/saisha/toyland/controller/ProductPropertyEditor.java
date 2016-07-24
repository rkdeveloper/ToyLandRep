package com.saisha.toyland.controller;

import java.beans.PropertyEditorSupport;

import com.saisha.toyland.dao.ProductDAO;
import com.saisha.toyland.model.Category;
import com.saisha.toyland.model.Product;
import com.saisha.toyland.model.Supplier;

public class ProductPropertyEditor extends PropertyEditorSupport{

ProductDAO productDAO;
	
	public ProductPropertyEditor(ProductDAO productDAO)
	{
		this.productDAO=productDAO;
		System.out.println("calling constructor");
	}
	
	public void setAsText(String incoming)
	{
		
		Product product =  productDAO.getProduct(Integer.parseInt(incoming));
		Category category = product.getCategory();
		setValue(category);
		Supplier supplier = product.getSupplier();
		setValue(supplier);
		
		System.out.println("calling setAsText " + incoming);
		
	}
	public String getAsText()
	{
		System.out.println("calling getAsText");
		return new Integer(((Product)getValue()).getProductId()).toString();
	}
}
