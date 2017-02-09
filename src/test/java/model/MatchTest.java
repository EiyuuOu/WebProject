package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.model.Match;
import com.fdmgroup.model.Matchwinner;

import junit.framework.TestCase;


public class MatchTest extends TestCase{

	Match match;
	Match matchField;
	@Before
	public void setUp(){
		match = new Match();
		matchField = new Match("bla", "blubb", 1.35, 2.5, Matchwinner.TBD);
			}
	
	@Test
	public void test_Constructor_Match_WithEmptyFields(){
		Match match1 = match;
		assertEquals(match1, match);
	}
	
	@Test
	public void test_Constructor_Match_WithFields(){
		Match match1 = matchField;
		assertEquals(match1, matchField);
	}
	
	@Test
	public void test_GettersAndSetters_ReturnsObjectFields_IfCalled(){
		Match match1 = new Match();
		
		match1.setId(5);
		match1.setPlayerNameOne("noki");
		match1.setPlayerNameTwo("niko");
		match1.setOddsPlayerOne(1.35);
		match1.setOddsPlayerTwo(1.5);
		match1.setWinner(Matchwinner.DRAW);
	
		System.out.println(  match1.getId()+ 
							 match1.getPlayerNameOne()+
							 match1.getPlayerNameTwo()+
							 match1.getOddsPlayerOne()+
							 match1.getOddsPlayerTwo()+
							 match1.getWinner());
	}
	
	@Test
	public void test_toString_returnsStringOfMatchFieldsInConsole_ifCalled(){
	
	System.out.println(matchField.toString());
	}
	
	@After
	public void tearDown(){
		match = null;
		matchField = null;
	}

}
