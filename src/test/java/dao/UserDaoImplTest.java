package dao;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.dao.UserDaoImpl;
import com.fdmgroup.dao.UserMatchDao;
import com.fdmgroup.model.Match;
import com.fdmgroup.model.Users;

import junit.framework.TestCase;

public class UserDaoImplTest extends TestCase{
	
	public UserDao userDao;
	public UserMatchDao userMatchDao;
	public Users user1;
	public Users user2;
	public Users user3;
	
	
	@Before
	public void setUp(){
		userDao = new UserDaoImpl();
		user2 = new Users("Niko", "Brah", "Strassencobra", "blubb", "bla@blubb1.de", 500);
		user3 = new Users("Niko", "Brah", "Blotto", "blubb", "bla@blubb.de", 500);
	}

	@Test
	public void test_CreateNewUser_ReturnsBoolPass_IfUserIsCreated() {
		
		boolean bool = userDao.newUser(user2);
		assertEquals(bool, true);
	}
	
	@Test
	public void test_GetUser_ReturnsUser_IfUserIsExists() {
		
		Users user4 = userDao.getUser("bla@blubb1.de");
		assertEquals(user4.getEmail(), user2.getEmail() );
	}
	
	@Test
	public void test_Update_Returns1_IfUserDataUpdated() {
		Users user4 = new Users("Niko", "Brah", "Noki", "blubb", "bla@blubb1.de", 500);
		userDao.updateUser(59, user4);
		assertEquals(user2.getUsername(), user4.getUsername());
	}
	
	@Test
	public void test_Delete_Returns1_IfUserIsDeleted() {
	
		userDao.deleteUser(59);
		assertEquals(59, null);
	}
	
	@Test
	public void test_GetAllUsers_ReturnsList_IfCalled() {
	
		List<Users> userList = userDao.getAllUsers();
		assertEquals(4, userList.size());
	}
	
	@Test
	public void test_GetAllMatches_ReturnsList_IfCalled() {
		
		List<Match> matchList = userMatchDao.getAllMatches();
		assertEquals(5, matchList.size());
	}
	
	
	
	
	@After
	public void tearDown(){
		userDao = null;
		user2 = null;
		user3 = null;
	}

}
