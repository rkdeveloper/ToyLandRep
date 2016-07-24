package com.saisha.toyland.dao;

import java.util.List;

import com.saisha.toyland.model.Category;

public interface CategoryDAO {

	public void addNewCategory(Category category);
	public List<Category> getCategories();
	public Category edit(int id, Category c);
	public Category getCategory(int id);
	public void delete(int id);
}