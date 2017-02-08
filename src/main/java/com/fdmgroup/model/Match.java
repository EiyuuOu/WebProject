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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(oddsPlayerOne);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(oddsPlayerTwo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((playerOne == null) ? 0 : playerOne.hashCode());
		result = prime * result + ((playerTwo == null) ? 0 : playerTwo.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(oddsPlayerOne) != Double.doubleToLongBits(other.oddsPlayerOne))
			return false;
		if (Double.doubleToLongBits(oddsPlayerTwo) != Double.doubleToLongBits(other.oddsPlayerTwo))
			return false;
		if (playerOne == null) {
			if (other.playerOne != null)
				return false;
		} else if (!playerOne.equals(other.playerOne))
			return false;
		if (playerTwo == null) {
			if (other.playerTwo != null)
				return false;
		} else if (!playerTwo.equals(other.playerTwo))
			return false;
		if (winner != other.winner)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", playerNameOne=" + playerOne + ", playerNameTwo=" + playerTwo
				+ ", oddsPlayerOne=" + oddsPlayerOne + ", oddsPlayerTwo=" + oddsPlayerTwo + ", winner=" + winner + "]";
	}
	
	
	

}
