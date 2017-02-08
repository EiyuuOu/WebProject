package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Player;



public interface AdminPlayerDao {
	
	public boolean newPlayer(Player player);
	public Player getPlayer(String username);
	public int updatePlayer(int id, Player player);
	public int deletePlayer(int id);
	public List<Player> getAllPlayer();

}
