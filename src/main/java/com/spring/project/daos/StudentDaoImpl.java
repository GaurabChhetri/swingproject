package com.spring.project.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.models.Student;
@Repository
public class StudentDaoImpl implements StudentDao{
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.save(s);
		
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		Student s = (Student) session.get(Student.class,id);
		session.delete(s);
		
	}

	@Override
	@Transactional
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.update(s);
		
	}

	@Override
	@Transactional
	public Student getById(int id) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		Student s = (Student) session.get(Student.class,id);
		return s;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		Criteria crt = session.createCriteria(Student.class);
		List<Student> slist = crt.list();
		return slist;
	}

}
