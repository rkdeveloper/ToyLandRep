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

import com.saisha.toyland.model.Product;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory mysessionFactory;
	
	public void addNewProduct(Product product) {
		Session session = mysessionFactory.openSession();
		Serializable objId = session.save(product);
		System.out.println(objId.toString());
		if(objId != null)
			System.out.println("new product added to the database");
		else
			System.out.println("new product cannot be added");
		session.close();
	}

	public List<Product> getProducts() {
		Session session = mysessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> productList = criteria.list();
		session.close();
		return productList;
	}

	public Product edit(int id, Product p) {
		System.out.println("editing product details..");
		 Session session = mysessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 Product pd = (Product)session.get(Product.class, id);
		 pd.setProductName(p.getProductName());
		 pd.setProductDescription(p.getProductDescription());
		 pd.setProductPrice(p.getProductPrice());
		 pd.setStock(p.getStock());
		 session.saveOrUpdate(pd);
		 tx.commit();
		 session.close();
		 return pd;
	}

	public Product getProduct(int id) {
		Session session = mysessionFactory.openSession();
		Product pd = (Product)session.get(Product.class,id);
		return pd;
	}

	public void delete(int id) {
		System.out.println("Product is being deleted permanently..");
		Session session = mysessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Product pd = (Product)session.load(Product.class, id);
		session.delete(pd);
		tx.commit();
		session.close();
	}
}