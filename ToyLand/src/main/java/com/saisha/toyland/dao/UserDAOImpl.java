package com.saisha.toyland.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saisha.toyland.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory mysessionFactory;
		
	public void addNewUser(User user)
	{
		Session session = mysessionFactory.openSession();
		Serializable objId = session.save(user);
		System.out.println(objId.toString());
		if(objId!=null)
			System.out.println("User Added");
		else
			System.out.println("Registration Failed");
		session.close();
	}
	
	public boolean getUser(User user)
	{
		Session session = mysessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		List myList = criteria.list();
		session.close();
		if(myList.isEmpty())
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
}