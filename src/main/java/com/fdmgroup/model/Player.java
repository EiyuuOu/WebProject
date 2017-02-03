package com.fdmgroup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstname;
	private String lastname;
	private int age;
	private String username;
	private String team;
	private String nationality;
	private String race;
	//team id FK
	
	public Player(){
		
	}
	
	
}