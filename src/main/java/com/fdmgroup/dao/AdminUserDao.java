package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Users;

public interface AdminUserDao extends UserDao {
	
	//http://stackoverflow.com/questions/11638155/java-session-filters-with-users-and-admin-login
	//http://www.informit.com/articles/article.aspx?p=24253
	//Check out SVN!!
	//create admin class in model
	// dont extend UserDao
	// create 2 interfaces for admin (for user and for player)
	public int deleteUser(String email);
	public List<Users> getAllUsers();
	public int changeBalance(String email, Users users);
	
	
	
}
