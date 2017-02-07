package com.fdmgroup.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.model.Users;

public class AdminDaoImpl extends UserDaoImpl implements AdminUserDao {

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
		
//		Query query = em.createQuery("update Users users"
//				+ "set users.balance=:newBalance"
//				+ "where users.email=:email");
//		
//		query.setParameter("balance", users.getBalance());
//		
//		int result = query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
		return 1;
	}
	
//	public static void main(String args[]){
//		AdminDaoImpl admin = new AdminDaoImpl();
//		Users user = admin.getUser("Niko@fdm.com");
//		admin.changeBalance(user.getId(), 1337);	
//	}

}
