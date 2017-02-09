package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.model.Match;
import com.fdmgroup.model.Matchwinner;
import com.fdmgroup.model.Users;

public class UserDaoImpl implements UserDao, UserMatchDao{
	
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
	@Override
	public List<Match> getAllMatches() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select match from Match match", Match.class);
		
		List<Match> matchList = (List<Match>)query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return matchList;
	}
	
	/*
	 * TODO Implement bet function
	 */
//	@Override
//	public double makeBet(int id, String playerName, double amount) {
//		EntityManager em = getEntityManager();
//		double balanceChange;
//		em.getTransaction().begin();
//		Match match = em.find(Match.class, id);
//		
//		if ((playerName.equalsIgnoreCase(match.getPlayerNameOne() )&& (match.getWinner() == Matchwinner.PLAYERONE))){
//			balanceChange = amount*match.getOddsPlayerOne();
//			return balanceChange;
//		}
//		else if ((playerName.equalsIgnoreCase(match.getPlayerNameOne() )&& (match.getWinner() == Matchwinner.PLAYERTWO))){
//			balanceChange = -amount;
//			
//			return balanceChange;
//		}
//		else if ((playerName.equalsIgnoreCase(match.getPlayerNameTwo() )&& (match.getWinner() == Matchwinner.PLAYERTWO))){
//			balanceChange = amount*match.getOddsPlayerTwo();
//			return balanceChange;
//		}
//		else if ((playerName.equalsIgnoreCase(match.getPlayerNameTwo() )&& (match.getWinner() == Matchwinner.PLAYERONE))){
//			balanceChange = -amount;
//			
//			return balanceChange;
//		}
//		else return amount;
//		
//		return 0;
//	}
//
//	@Override
//	public Users userBalanceChange(int id, double amount) {
//		EntityManager em = getEntityManager();
//		Users user = em.find(Users.class, id);
//		em.getTransaction().begin();
//		user.setBalance(user.getBalance()+amount);
//		em.getTransaction().commit();
//		em.close();
//		return user
//		return null;
//	}

//	public static void main(String[] args) {
//		UserDaoImpl dao = new UserDaoImpl();
//		Users user = dao.getUser("abc@msn.com");
//		System.out.println(user);
//		
//	}

}
