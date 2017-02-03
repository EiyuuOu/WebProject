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
	
	public int updateUser(String email, Users users) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("update Users users"
				+ "set users.firstname=:firstname,"
				+ "users.lastname=:lastname,"
				+ "users.username=:username,"
				+ "users.password=:password,"
				+ "users.email=:email,"
				+ "where users.email=:email");
		query.setParameter("firstname", users.getFirstname());
		query.setParameter("lastname", users.getLastname());
		query.setParameter("username", users.getUsername());
		query.setParameter("password", users.getPassword());
		query.setParameter("email", users.getEmail());
		
		int result = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		return result;
	}
	public int deleteUser(String email) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("delete users from Users users where users.email=:email", Users.class);
		query.setParameter("email", email);
		int result = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		return result;
		
	}
	public List<Users> getAllUsers() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select users from Users users", Users.class);
		
		List<Users> usersList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return usersList;
	}


//	public static void main(String[] args) {
//		UserDaoImpl dao = new UserDaoImpl();
//		Users user = dao.getUser("abc@msn.com");
//		System.out.println(user);
//		
//	}

}
