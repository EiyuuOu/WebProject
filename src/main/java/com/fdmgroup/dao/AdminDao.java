package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Users;

public class AdminDao implements AdminUserDao {

	@Override
	public boolean newUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUser(String email, Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int changeBalance(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changeBalance(String email, Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

}
