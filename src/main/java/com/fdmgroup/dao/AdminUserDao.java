package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Player;
import com.fdmgroup.model.Users;

public interface AdminUserDao extends UserDao {
	//3.2.
	//http://stackoverflow.com/questions/11638155/java-session-filters-with-users-and-admin-login
	//http://www.informit.com/articles/article.aspx?p=24253
	//Check out SVN!!
	//create admin class in model
	// dont extend UserDao
	// create 2 interfaces for admin (for user and for player)
	//public boolean newUser(Users users);
	public int deleteUser(String email);
	public List<Users> getAllUsers();
	public int changeBalance(String email, Users users);
	int updateUser(String email, Users users);
	
	
	/*
	 * 6.2.
	 * 
	 * http://stackoverflow.com/questions/14544980/how-to-restrict-every-user-roles-in-jsp-servlet
	 * http://stackoverflow.com/questions/13274279/authentication-filter-and-servlet-for-login
	 * http://stackoverflow.com/questions/9965708/how-to-handle-authentication-authorization-with-users-in-a-database
	 * 
	 * 
	 */
	
	
}
