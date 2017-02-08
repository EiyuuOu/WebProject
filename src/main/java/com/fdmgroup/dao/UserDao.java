package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Users;

public interface UserDao {
	
	public boolean newUser(Users user);
	public Users getUser(String email);
	public int updateUser(int id, Users users);
	public int deleteUser(int id);
	public List<Users> getAllUsers();

}
