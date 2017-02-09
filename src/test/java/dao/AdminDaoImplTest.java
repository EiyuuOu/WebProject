package dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.dao.AdminDaoImpl;
import com.fdmgroup.dao.AdminMatchDao;
import com.fdmgroup.dao.AdminPlayerDao;
import com.fdmgroup.dao.AdminUserDao;
import com.fdmgroup.model.Player;
import com.fdmgroup.model.Race;
import com.fdmgroup.model.Users;

import junit.framework.TestCase;

public class AdminDaoImplTest extends TestCase{
	
	AdminUserDao adminUserDao;
	AdminPlayerDao adminPlayerDao;
	AdminMatchDao adminMatchDao;
	
	Users user;
	Player player;

	@Before
	public void setUp(){
		adminUserDao = new AdminDaoImpl();
		
	}
	
	@Test
	public void test_GetAllMatches_ReturnsList_IfCalled() {
		user = adminUserDao.getUser("bla@blubb.de");
		int id = user.getId();
		int result = adminUserDao.changeBalance(id, 666);
		assertEquals(result, 1);	
	}
	
	@Test
	public void test_CreateNewPlayer_ReturnsBool_IfPlayerCreated() {
		player = new Player("Mike", "Miller", 35, "Snoopy", "F4", "USA", Race.TERRAN);
		
	}
	
	@After
	public void tearDown(){
		user = null;
		adminUserDao = null;
	}

}
