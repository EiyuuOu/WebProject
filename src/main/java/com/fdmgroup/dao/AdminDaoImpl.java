package com.fdmgroup.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.model.Player;
import com.fdmgroup.model.Users;

public class AdminDaoImpl extends UserDaoImpl implements AdminUserDao, AdminPlayerDao {

	EntityManagerFactory emf;
	EntityManager em;

	private EntityManager getEntityManager(){
		emf = Persistence.createEntityManagerFactory("oracle");
		em = emf.createEntityManager();
		
		return em;
	}
	
	/**
	 * User CRUD inherited from UserDaoImpl
	 * 
	 * Adding Method to change user Balance
	 */

	@Override
	public int changeBalance(int id, double newBalance) {
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Users user = em.find(Users.class, id);
		user.setBalance(newBalance);
		em.getTransaction().commit();
		em.close();
		
		return 1;
	}
	
	/**
	 * Adding CRUD functionality to Player
	 */

	@Override
	public boolean newPlayer(Player player) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(player);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return true;
	}

	@Override
	public Player getPlayer(String username) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select player from Player player where player.username=:username", Player.class);
		query.setParameter("username", username);
		Player player = (Player) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return player;
	}

	@Override
	public int updatePlayer(String username, Player player) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("update Player "
				+ "set firstname=:firstname,"
				+ "lastname=:lastname,"
				+ "age=:age,"
				+ "username=:username,"
				+ "team=:team,"
				+ "nationality=:nationality,"
				+ "race=:race,"
				+ "where id=:id");
		query.setParameter("firstname", player.getFirstname());
		query.setParameter("lastname", player.getLastname());
		query.setParameter("age", player.getAge());
		query.setParameter("username", username);
		query.setParameter("team", player.getTeam());
		query.setParameter("nationality", player.getNationality());
		query.setParameter("race", player.getRace());
		
		int result = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		return result;
	}

	@Override
	public int deletePlayer(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Player> getAllPlayer() {
		// TODO Auto-generated method stub
		return null;
	}


}
