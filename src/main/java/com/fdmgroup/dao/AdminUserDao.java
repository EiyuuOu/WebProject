package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Users;

public interface AdminUserDao extends UserDao {
	
	//http://stackoverflow.com/questions/11638155/java-session-filters-with-users-and-admin-login
	//http://www.informit.com/articles/article.aspx?p=24253
	public int deleteUser(String email);
	public List<Users> getAllUsers();
	public int changeBalance(String email, Users users);
	
	
	
}
