package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	public Users getUser(String email) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select users from Users users where users.email=:email", Users.class);
		query.setParameter("email", email);
		Users user = (Users) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return user;
	}
	
	public Users updateUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


//	public static void main(String[] args) {
//		UserDaoImpl dao = new UserDaoImpl();
//		Users user = dao.getUser("test9@msn.com");
//		System.out.println(user);
//		
//	}

}
