package com.saisha.toyland.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saisha.toyland.model.Supplier;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Transactional
@Repository
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	SessionFactory mysessionFactory;

	public void addNewSupplier(Supplier supplier) {
		Session session = mysessionFactory.openSession();
		Serializable objId = session.save(supplier);
		System.out.println(objId.toString());
		if(objId != null)
			System.out.println("new toy supplier has been added to the database");
		else
			System.out.println("new supplier cannot be added");
		session.close();
	}

	public List<Supplier> getSupplier() {
		Session session = mysessionFactory.openSession();
		Criteria criteria = session.createCriteria(Supplier.class);
		List<Supplier> supplierList = criteria.list();
		session.close();
		return supplierList;
	}

	public Supplier edit(int id, Supplier s) {
		System.out.println("editing toy supplier..");
		 Session session = mysessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
		 Supplier sup = (Supplier)session.get(Supplier.class, id);
		 sup.setSupplierName(s.getSupplierName());
		 sup.setContactPerson(s.getContactPerson());
		 sup.setContactNumber(s.getContactNumber());
		 sup.setFloor(s.getFloor());
		 sup.setBuildingName(s.getBuildingName());
		 sup.setAreaName(s.getAreaName());
		 sup.setCity(s.getCity());
		 sup.setPincode(s.getPincode());
		 sup.setState(s.getState());
		 session.saveOrUpdate(sup);
		 tx.commit();
		 session.close();
		 return sup;
	}

	public Supplier getSupplier(int id) {
		Session session = mysessionFactory.openSession();
		Supplier supplier = (Supplier)session.get(Supplier.class,id);
		return supplier;
	}

	public void delete(int id) {
		System.out.println("Supplier is being deleted permanently..");
		Session session = mysessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Supplier sup = (Supplier)session.load(Supplier.class, id);
		session.delete(sup);
		tx.commit();
		session.close();
	}	
}