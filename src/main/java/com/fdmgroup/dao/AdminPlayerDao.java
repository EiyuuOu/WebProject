package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Player;



public interface AdminPlayerDao {
	
	public boolean newPlayer(Player player);
	public Player getUser(String username);
	public int updateUser(String username, Player player);
	public int deleteUser(String username);
	public List<Player> getAllUsers();

}
