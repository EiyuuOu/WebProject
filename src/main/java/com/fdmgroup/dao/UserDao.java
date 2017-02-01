package com.fdmgroup.dao;

import java.util.List;


import com.fdmgroup.model.Users;

public interface UserDao {
	
	public boolean newUser(Users user);
	public Users getUser(String username);
	public Users updateUser(String username);
	public boolean deleteUser(String username);
	public List<Users> getAllUsers();
	

}
