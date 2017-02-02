package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Users;

public interface UserDao {
	
	public boolean newUser(Users user);
	public Users getUser(String email);
	public Users updateUser(String email);
	public boolean deleteUser(String email);
	public List<Users> getAllUsers();
	

}
