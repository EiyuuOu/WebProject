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
	
	public int updateUser(int id, Users users) {
		EntityManager em = getEntityManager();
		Users user = em.find(Users.class, id);
		em.getTransaction().begin();
		user.setFirstname(users.getFirstname());
		user.setLastname(users.getLastname());
		user.setUsername(users.getUsername());
		user.setEmail(user.getEmail());
//		
//		Query query = em.createQuery("Update Users "
//				+ "set firstname=:firstname,"
//				+ "lastname=:lastname,"
//				+ "username=:username,"
//				+ "email=:email"
//				+ "where id=:id");
//		query.setParameter("firstname", users.getFirstname());
//		query.setParameter("lastname", users.getLastname());
//		query.setParameter("username", users.getUsername());
//		query.setParameter("email", users.getEmail());
//		query.setParameter("id", id);
//		
		em.getTransaction().commit();
		em.close();
		
		return 1;
	}
	
	public int deleteUser(int id) {
		EntityManager em = getEntityManager();
		Users user = em.find(Users.class, id);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
		em.close();
		
		return 1;
		
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
