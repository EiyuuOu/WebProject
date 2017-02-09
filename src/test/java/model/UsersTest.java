package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.model.Roles;
import com.fdmgroup.model.Users;

import junit.framework.TestCase;

public class UsersTest extends TestCase {
	Users user;
	Users userField;
	
	@Before
	public void setUp(){
		user = new Users();
		userField = new Users("niko", "brah", "noki", "bla", "test@test.de", 300);
	}
	
	@Test
	public void test_Constructor_Users_WithEmptyFields(){
		Users user1 = user;
		assertEquals(user, user1);
	}
	
	@Test
	public void test_Constructor_Users_Fields(){
		Users userField2 = userField;
		assertEquals(userField, userField2);
	}
	
	@Test
	public void test_GettersAndSetters_ReturnsObjectFields_IfCalled(){
		Users user2 = new Users();
		user.setId(5);
		user2.setFirstname("Noki");
		user2.setLastname("brah");
		user2.setUsername("kobra");
		user2.setPassword("bla");
		user2.setEmail("bla@bla.de");
		user2.setRole(Roles.USER);
		user2.setBalance(500);
		user2.setRegisterDate(null);
		user2.setLastLoggedIn(null);

		System.out.println(user2.getId()+
						   user2.getFirstname()+
						   user2.getLastname()+
						   user2.getUsername()+
						   user2.getPassword()+
						   user2.getEmail()+
						   user2.getRole()+
						   user2.getBalance()+
						   user2.getRegisterDate()+
						   user2.getLastLoggedIn()
						   );
		
	}
	
	@Test
	public void test_toString_returnsStringOfUserFieldsInConsole_ifCalled(){
		System.out.println(userField.toString());
	}
	
	
	
	@After
	public void tearDown(){
		user = null;
		userField = null;
	}

}
