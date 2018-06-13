package com.spring.project.daos;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.models.User;

@Repository

public class UserDaoImpl  implements UserDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void signup(User u) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		session.save(u);
	}

	@Override
	public boolean login(String un, String psw) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Criteria crt=session.createCriteria(User.class);
		crt.add(Restrictions.eq("username",un)).add(Restrictions.eq("password",psw));
		
		User u = (User) crt.uniqueResult();
		if(u!=null){
			return true;
		}
		return false;
	}

}
