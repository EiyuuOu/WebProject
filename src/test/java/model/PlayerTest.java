package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.model.Player;
import com.fdmgroup.model.Race;
import com.fdmgroup.model.Roles;
import com.fdmgroup.model.Users;

import junit.framework.TestCase;




public class PlayerTest extends TestCase{

	Player player;
	Player playerField;

	@Before
	public void setUp(){
		player = new Player();
		playerField = new Player("Niko", "Brah", 20, "Kobra", "SKT", "Germany", Race.PROTOSS);
		}
	
	@Test
	public void test_Constructor_Player_WithEmptyFields(){
		Player player1 = player;
		assertEquals(player, player1);
	}
	
	@Test
	public void test_Constructor_Player_WithFields(){
		Player playerField1 = playerField;
		assertEquals(playerField1, playerField);
	}
	
	@Test
	public void test_GettersAndSetters_ReturnsObjectFields_IfCalled(){
		Player player2 = new Player();
		player2.setId(5);
		player2.setFirstname("Noki");
		player2.setLastname("brah");
		player2.setAge(30);;
		player2.setUsername("Kobra");
		player2.setTeam("SKT");
		player2.setNationality("Germany");
		player2.setRace(Race.PROTOSS);


		System.out.println(player2.getId()+
						   player2.getFirstname()+
						   player2.getLastname()+
						   player2.getAge()+
						   player2.getUsername()+
						   player2.getTeam()+
						   player2.getNationality()+
						   player2.getRace()
						   );
		
	}
	
	@Test
	public void test_toString_returnsStringOfPlayerFieldsInConsole_ifCalled(){
		System.out.println(playerField.toString());
	}
	
	
	@After
	public void tearDown(){
		player = null;
		playerField = null;
	}

}
