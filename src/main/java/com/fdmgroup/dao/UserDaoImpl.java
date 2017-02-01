package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.fdmgroup.model.Users;

public class UserDaoImpl implements UserDao{
	
	EntityManagerFactory emf;
	EntityManager em;

	private EntityManager getEntityManager(){
		emf = Persistence.createEntityManagerFactory("oracle");
		em = emf.createEntityManager();
		
		return em;
	}
	public boolean newUser(Users person) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return true;
	}
	public Users getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public Users updateUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
