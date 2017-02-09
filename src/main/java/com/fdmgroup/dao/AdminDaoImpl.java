package com.fdmgroup.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fdmgroup.model.Match;
import com.fdmgroup.model.Player;
import com.fdmgroup.model.Users;

public class AdminDaoImpl extends UserDaoImpl implements AdminUserDao, AdminPlayerDao, AdminMatchDao {

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
	public int updatePlayer(int id, Player player) {
		EntityManager em = getEntityManager();
		
		Player players = em.find(Player.class, id);
		em.getTransaction().begin();
		players.setFirstname(player.getFirstname());
		players.setLastname(player.getLastname());
		players.setAge(player.getAge());
		players.setTeam(player.getTeam());
		players.setNationality(player.getNationality());
		players.setRace(player.getRace());		
		
		em.getTransaction().commit();
		em.close();
		
		return 1;
	}

	@Override
	public int deletePlayer(int id) {
		EntityManager em = getEntityManager();
		Player player = em.find(Player.class, id);
		em.getTransaction().begin();
		em.remove(player);
		em.getTransaction().commit();
		em.close();
		
		return 1;
	}

	@Override
	public List<Player> getAllPlayer() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select player from Player player", Player.class);
		
		List<Player> playerList = (List<Player>)query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return playerList;
	}
	
	/**
	 * Match functionality
	 * 
	 */
	
	@Override
	public int newMatch(Match match) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(match);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return 1;
	}

	@Override
	public Match getMatch(String playerOne, String playerTwo) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select match from Match match where match.playerOne=:playerOne AND match.playerTwo=:playerTwo", Match.class);
		query.setParameter("playerOne", playerTwo).setParameter("playerTwo", playerTwo);
		Match match = (Match) query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return match;
	}

	@Override
	public List<Match> getAllMatches() {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select match from Match match", Match.class);
		
		List<Match> matchList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return matchList;
	}
	
//	public static void main(String args[]){
//		AdminDaoImpl dao = new AdminDaoImpl();
//		List<Player> playerList = dao.getAllPlayer();
//		
//		for (Player member : playerList) {
//			System.out.println(member);
//		}
//	}


}
