package com.fdmgroup.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String playerOne;
	private String playerTwo;
	private double oddsPlayerOne;
	private double oddsPlayerTwo;
	@Enumerated(EnumType.STRING)
	private Matchwinner winner;
	
	public Match(){
		
	}

	public Match(String playerNameOne, String playerNameTwo, double oddsPlayerOne, double oddsPlayerTwo,
			Matchwinner winner) {
		super();
		this.playerOne = playerNameOne;
		this.playerTwo = playerNameTwo;
		this.oddsPlayerOne = oddsPlayerOne;
		this.oddsPlayerTwo = oddsPlayerTwo;
		this.winner = winner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerNameOne() {
		return playerOne;
	}

	public void setPlayerNameOne(String playerNameOne) {
		this.playerOne = playerNameOne;
	}

	public String getPlayerNameTwo() {
		return playerTwo;
	}

	public void setPlayerNameTwo(String playerNameTwo) {
		this.playerTwo = playerNameTwo;
	}

	public double getOddsPlayerOne() {
		return oddsPlayerOne;
	}

	public void setOddsPlayerOne(double oddsPlayerOne) {
		this.oddsPlayerOne = oddsPlayerOne;
	}

	public double getOddsPlayerTwo() {
		return oddsPlayerTwo;
	}

	public void setOddsPlayerTwo(double oddsPlayerTwo) {
		this.oddsPlayerTwo = oddsPlayerTwo;
	}

	public Matchwinner getWinner() {
		return winner;
	}

	public void setWinner(Matchwinner winner) {
		this.winner = winner;
	}


	@Override
	public String toString() {
		return "Match [id=" + id + ", playerNameOne=" + playerOne + ", playerNameTwo=" + playerTwo
				+ ", oddsPlayerOne=" + oddsPlayerOne + ", oddsPlayerTwo=" + oddsPlayerTwo + ", winner=" + winner + "]";
	}
	
	
	

}
