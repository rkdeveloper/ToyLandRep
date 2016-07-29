package com.saisha.toyland.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saisha.toyland.model.Category;

@Transactional
@Repository
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	SessionFactory mysessionFactory;
	
	public void addNewCategory(Category category)
	{
		Session session = mysessionFactory.openSession();
		Serializable objId = session.save(category);
		System.out.println(objId.toString());
		if(objId != null)
			System.out.println("new category added to the database");
		session.close();
	}	
	
	public List<Category> getCategories()
	{
		Session session = mysessionFactory.openSession();
		Criteria criteria = session.createCriteria(Category.class);
		List<Category> categoryList = criteria.list();
		session.close();
		return categoryList;
	}

	public Category edit(int id, Category category) {
		 System.out.println("editing category..");
		 Session session = mysessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 Category cat = (Category)session.get(Category.class, id);
		 cat.setCategoryDescription(category.getCategoryDescription());
		 cat.setCategoryName(category.getCategoryName());
		 System.out.println(cat.getCategoryDescription());
		 session.saveOrUpdate(cat);
		 tx.commit();
		 session.close();
		 return cat;
	}

	public void delete(int id) {
		System.out.println("Category is being deleted permanently..");
		Session session = mysessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Category cat = (Category)session.load(Category.class, id);
		session.delete(cat);
		tx.commit();
		session.close();
	}

	public Category getCategory(int id) {
		Session session = mysessionFactory.openSession();
		Category category = (Category)session.get(Category.class,id);
		return category;
	}
}