package saveOurPlanet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	// instantiate player object
	Player player1; 
	// declare test vars 
	String name;
	int resourceBalance, currentPosition, turn, balanceAmountChange; 
	int newBalanceIncrease, newBalanceSubtract;
	
	
	@BeforeEach
	void setUp() throws Exception {
		player1 = new Player();
		// initialise test vars
		name = "Test Player";
		resourceBalance = 500;
		currentPosition = 0; 
		turn = 1;
		balanceAmountChange = 500; 
		newBalanceIncrease = 1000;
		newBalanceSubtract = 0; 
	}
	
	
	// Testing basic player constructor
	@Test
	void testPlayer() {
		Player player2 = new Player();
		assertNotNull(player2);
	}
	
	
	// Testing player constructor with args
	@Test
	void testPlayerStringIntIntInt() {
		Player player3 = new Player (name, resourceBalance, currentPosition);		
		assertNotNull(player3);
		
		assertEquals(name, player3.getName());
		assertEquals(resourceBalance, player3.getResourceBalance());
		assertEquals(currentPosition, player3.getCurrentPosition());		
	}
	
	
	// Testing setName & getName methods
	@Test
	void testSetGetName() {
		player1.setName(name);
		assertEquals(name, player1.getName());
	}
	

	// Testing setResourceBalance & getResourceBalance methods
	@Test
	void testSetGetResourceBalance() {
		player1.setResourceBalance(resourceBalance);
		assertEquals(resourceBalance, player1.getResourceBalance());
	}
	

	// Testing setCurrentPosition & getCurrentPosition methods
	@Test
	void testSetGetCurrentPosition() {
		player1.setCurrentPosition(currentPosition);
		assertEquals(currentPosition, player1.getCurrentPosition());
	}

}

