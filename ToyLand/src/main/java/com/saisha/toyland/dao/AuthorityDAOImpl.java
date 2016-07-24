package com.saisha.toyland.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.saisha.toyland.model.Authority;

@Transactional
@Repository
public class AuthorityDAOImpl implements AuthorityDAO{

	@Autowired
	SessionFactory mysessionFactory;
	
	public Authority getAuthorityById(int id) {
		Session session = mysessionFactory.openSession();
		Criteria criteria = session.createCriteria(Authority.class);
		criteria.add(Restrictions.eq("authorityId", id));
		List<Authority> alist = criteria.list();
		if(alist.isEmpty())
			return null;
		else
			return(Authority)alist.get(0);
	}
}