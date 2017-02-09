package com.fdmgroup.dao;

import java.util.List;

import com.fdmgroup.model.Match;

public interface AdminMatchDao {
	
	public int newMatch(Match match);
	public Match getMatch(String playerOne, String playerTwo);
	

}
