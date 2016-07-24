package com.saisha.toyland.dao;

import java.util.List;

import com.saisha.toyland.model.Product;

public interface ProductDAO {

	public void addNewProduct(Product product);
	public List<Product> getProducts();
	public Product edit(int id, Product p);
	public Product getProduct(int id);
	public void delete(int id);
}
