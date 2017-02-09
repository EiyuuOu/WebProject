package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Match;
import com.fdmgroup.model.Users;

public interface UserMatchDao {
	
	public List<Match> getAllMatches();
	
	/**
	 * TODO Implement functions to place bets
	 */
	//public double makeBet(int id, String playerName, double amount);
	//public Users userBalanceChange(int id, double amount);

}
