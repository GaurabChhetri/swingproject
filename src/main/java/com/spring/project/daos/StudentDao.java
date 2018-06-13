package com.spring.project.daos;

import java.util.List;

import com.spring.project.models.Student;

public interface StudentDao {
	public void addStudent(Student s);
	public void deleteStudent(int id);
	public void updateStudent(Student s);
	public Student getById(int id);
	public List<Student> getAllStudent();

}
