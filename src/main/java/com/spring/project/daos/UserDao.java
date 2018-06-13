package com.spring.project.daos;

import com.spring.project.models.User;

public interface UserDao {
	
	public void signup(User u);
	
	public boolean login(String un , String psw);

}
