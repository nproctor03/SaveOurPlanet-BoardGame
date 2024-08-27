package saveOurPlanet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {
	// instantiate board object
	Board board;
	
	// declare test vars 
	String squareName, areaField, owner;
	boolean owned;
	int buyCost, minDevCost, majorDevCost, rentNoDev, rentOneDev;
	int rentTwoDev, rentThreeDev, rentMajorDev, devCount, currentRent;

	@BeforeEach
	void setUp() throws Exception {
		// initialise test board object
		board = new Board();
	}

	/**
	 * Testing basic constructor
	 */
	@Test
	void testBoard() {
		Board board = new Board();
		assertNotNull(board);
	}

	
	/**
	 * Testing the expected values for square 1
	 */
	@Test
	void testGetBoardDetailsForSquare1() {
		squareName = "ECO Base";
		areaField = "Start";
		owner = null;
		owned = false;
		buyCost = 0;
		minDevCost = 0;
		majorDevCost = 0;
		rentNoDev = 200;
		rentOneDev = 0;
		rentTwoDev = 0;
		rentThreeDev = 0;
		rentMajorDev = 0;
		devCount = 0;
		currentRent = 0;
		
		assertEquals(squareName, board.getBoard()[0].getSquareName());
		assertEquals(areaField, board.getBoard()[0].getAreaField());
		assertEquals(owner, board.getBoard()[0].getOwner());
		assertEquals(owned, board.getBoard()[0].isOwned());
		assertEquals(buyCost, board.getBoard()[0].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[0].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[0].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[0].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[0].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[0].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[0].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[0].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[0].getDevCount());
		assertEquals(currentRent, board.getBoard()[0].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 2
	 */
	@Test
	void testGetBoardDetailsForSquare2() {
		squareName = "Charity";
		areaField = "Community";
		owner = null;
		owned = false;
		buyCost = 100;
		minDevCost = 50;
		majorDevCost = 100;
		rentNoDev = 5;
		rentOneDev = 10;
		rentTwoDev = 15;
		rentThreeDev = 20;
		rentMajorDev = 50;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[1].getSquareName());
		assertEquals(areaField, board.getBoard()[1].getAreaField());
		assertEquals(owner, board.getBoard()[1].getOwner());
		assertEquals(owned, board.getBoard()[1].isOwned());
		assertEquals(buyCost, board.getBoard()[1].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[1].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[1].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[1].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[1].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[1].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[1].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[1].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[1].getDevCount());
		assertEquals(currentRent, board.getBoard()[1].getCurrentRent());
	}

	
	/**
	 * Testing to update square 2 owner
	 */
	@Test
	void testUpdateSquare2Owner() {
		owner = "Mr Owner";
		board.getBoard()[1].setOwner(owner);
		assertEquals(owner, board.getBoard()[1].getOwner());
	}
	

	/**
	 * Testing to update square 2 owned status
	 */
	@Test
	void testUpdateSquare2OwnedStatus() {
		owned = true;
		board.getBoard()[1].setOwned(owned);
		assertEquals(owned, board.getBoard()[1].isOwned());
	}
	

	/**
	 * Testing to update square 2 owned status
	 */
	@Test
	void testUpdateSquare2DevCount() {
		devCount = 1;
		board.getBoard()[1].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[1].getDevCount());
	}
	

	/**
	 * Testing to update square 2 owned status
	 */
	@Test
	void testUpdateSquare2CurrentRent() {
		currentRent = 200;
		board.getBoard()[1].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[1].getCurrentRent());
	}
	

	/**
	 * Testing the expected values for square 3
	 */
	@Test
	void testGetBoardDetailsForSquare3() {
		squareName = "Recycling Centre";
		areaField = "Community";
		owner = null;
		owned = false;
		buyCost = 100;
		minDevCost = 50;
		majorDevCost = 100;
		rentNoDev = 5;
		rentOneDev = 10;
		rentTwoDev = 15;
		rentThreeDev = 20;
		rentMajorDev = 50;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[2].getSquareName());
		assertEquals(areaField, board.getBoard()[2].getAreaField());
		assertEquals(owner, board.getBoard()[2].getOwner());
		assertEquals(owned, board.getBoard()[2].isOwned());
		assertEquals(buyCost, board.getBoard()[2].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[2].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[2].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[2].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[2].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[2].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[2].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[2].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[2].getDevCount());
		assertEquals(currentRent, board.getBoard()[2].getCurrentRent());
	}
	

	/**
	 * Testing to update square 3 owner
	 */
	@Test
	void testUpdateSquare3Owner() {
		owner = "Mr Owner";
		board.getBoard()[2].setOwner(owner);
		assertEquals(owner, board.getBoard()[2].getOwner());
	}

	
	/**
	 * Testing to update square 3 owned status
	 */
	@Test
	void testUpdateSquare3OwnedStatus() {
		owned = true;
		board.getBoard()[2].setOwned(owned);
		assertEquals(owned, board.getBoard()[2].isOwned());
	}

	
	/**
	 * Testing to update square 3 owned status
	 */
	@Test
	void testUpdateSquare3DevCount() {
		devCount = 1;
		board.getBoard()[2].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[2].getDevCount());
	}

	
	/**
	 * Testing to update square 3 owned status
	 */
	@Test
	void testUpdateSquare3CurrentRent() {
		currentRent = 200;
		board.getBoard()[2].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[2].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 4
	 */
	@Test
	void testGetBoardDetailsForSquare4() {
		squareName = "Electric Cars";
		areaField = "Technology";
		owner = null;
		owned = false;
		buyCost = 300;
		minDevCost = 150;
		majorDevCost = 300;
		rentNoDev = 15;
		rentOneDev = 30;
		rentTwoDev = 45;
		rentThreeDev = 60;
		rentMajorDev = 150;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[3].getSquareName());
		assertEquals(areaField, board.getBoard()[3].getAreaField());
		assertEquals(owner, board.getBoard()[3].getOwner());
		assertEquals(owned, board.getBoard()[3].isOwned());
		assertEquals(buyCost, board.getBoard()[3].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[3].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[3].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[3].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[3].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[3].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[3].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[3].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[3].getDevCount());
		assertEquals(currentRent, board.getBoard()[3].getCurrentRent());
	}

	
	/**
	 * Testing to update square 4 owner
	 */
	@Test
	void testUpdateSquare4Owner() {
		owner = "Mr Owner";
		board.getBoard()[3].setOwner(owner);
		assertEquals(owner, board.getBoard()[3].getOwner());
	}

	
	/**
	 * Testing to update square 4 owned status
	 */
	@Test
	void testUpdateSquare4OwnedStatus() {
		owned = true;
		board.getBoard()[3].setOwned(owned);
		assertEquals(owned, board.getBoard()[3].isOwned());
	}

	
	/**
	 * Testing to update square 4 owned status
	 */
	@Test
	void testUpdateSquare4DevCount() {
		devCount = 1;
		board.getBoard()[3].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[3].getDevCount());
	}

	
	/**
	 * Testing to update square 4 owned status
	 */
	@Test
	void testUpdateSquare4CurrentRent() {
		currentRent = 200;
		board.getBoard()[3].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[3].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 5
	 */
	@Test
	void testGetBoardDetailsForSquare5() {
		squareName = "Carbon Capture";
		areaField = "Technology";
		owner = null;
		owned = false;
		buyCost = 300;
		minDevCost = 150;
		majorDevCost = 300;
		rentNoDev = 15;
		rentOneDev = 30;
		rentTwoDev = 45;
		rentThreeDev = 60;
		rentMajorDev = 150;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[4].getSquareName());
		assertEquals(areaField, board.getBoard()[4].getAreaField());
		assertEquals(owner, board.getBoard()[4].getOwner());
		assertEquals(owned, board.getBoard()[4].isOwned());
		assertEquals(buyCost, board.getBoard()[4].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[4].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[4].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[4].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[4].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[4].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[4].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[4].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[4].getDevCount());
		assertEquals(currentRent, board.getBoard()[4].getCurrentRent());
	}

	
	/**
	 * Testing to update square 5 owner
	 */
	@Test
	void testUpdateSquare5Owner() {
		owner = "Mr Owner";
		board.getBoard()[4].setOwner(owner);
		assertEquals(owner, board.getBoard()[4].getOwner());
	}

	
	/**
	 * Testing to update square 5 owned status
	 */
	@Test
	void testUpdateSquare5OwnedStatus() {
		owned = true;
		board.getBoard()[4].setOwned(owned);
		assertEquals(owned, board.getBoard()[4].isOwned());
	}

	
	/**
	 * Testing to update square 5 owned status
	 */
	@Test
	void testUpdateSquare5DevCount() {
		devCount = 1;
		board.getBoard()[4].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[4].getDevCount());
	}

	
	/**
	 * Testing to update square 5 owned status
	 */
	@Test
	void testUpdateSquare5CurrentRent() {
		currentRent = 200;
		board.getBoard()[4].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[4].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 6
	 */
	@Test
	void testGetBoardDetailsForSquare6() {
		squareName = "Coal";
		areaField = "Fossil Fuels";
		owner = null;
		owned = false;
		buyCost = 200;
		minDevCost = 100;
		majorDevCost = 200;
		rentNoDev = 10;
		rentOneDev = 20;
		rentTwoDev = 30;
		rentThreeDev = 40;
		rentMajorDev = 100;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[5].getSquareName());
		assertEquals(areaField, board.getBoard()[5].getAreaField());
		assertEquals(owner, board.getBoard()[5].getOwner());
		assertEquals(owned, board.getBoard()[5].isOwned());
		assertEquals(buyCost, board.getBoard()[5].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[5].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[5].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[5].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[5].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[5].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[5].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[5].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[5].getDevCount());
		assertEquals(currentRent, board.getBoard()[5].getCurrentRent());
	}

	
	/**
	 * Testing to update square 6 owner
	 */
	@Test
	void testUpdateSquare6Owner() {
		owner = "Mr Owner";
		board.getBoard()[5].setOwner(owner);
		assertEquals(owner, board.getBoard()[5].getOwner());
	}

	
	/**
	 * Testing to update square 6 owned status
	 */
	@Test
	void testUpdateSquare6OwnedStatus() {
		owned = true;
		board.getBoard()[5].setOwned(owned);
		assertEquals(owned, board.getBoard()[5].isOwned());
	}

	
	/**
	 * Testing to update square 6 owned status
	 */
	@Test
	void testUpdateSquare6DevCount() {
		devCount = 1;
		board.getBoard()[5].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[5].getDevCount());
	}

	
	/**
	 * Testing to update square 6 owned status
	 */
	@Test
	void testUpdateSquare6CurrentRent() {
		currentRent = 200;
		board.getBoard()[5].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[5].getCurrentRent());
	}

		
	/**
	 * Testing board object returns expected values for square 7
	 */
	@Test
	void testGetBoardDetailsForSquare7() {
		squareName = "Gas";
		areaField = "Fossil Fuels";
		owner = null;
		owned = false;
		buyCost = 200;
		minDevCost = 100;
		majorDevCost = 200;
		rentNoDev = 10;
		rentOneDev = 20;
		rentTwoDev = 30;
		rentThreeDev = 40;
		rentMajorDev = 100;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[6].getSquareName());
		assertEquals(areaField, board.getBoard()[6].getAreaField());
		assertEquals(owner, board.getBoard()[6].getOwner());
		assertEquals(owned, board.getBoard()[6].isOwned());
		assertEquals(buyCost, board.getBoard()[6].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[6].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[6].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[6].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[6].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[6].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[6].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[6].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[6].getDevCount());
		assertEquals(currentRent, board.getBoard()[6].getCurrentRent());
	}

	
	/**
	 * Testing to update square 7 owner
	 */
	@Test
	void testUpdateSquare7Owner() {
		owner = "Mr Owner";
		board.getBoard()[6].setOwner(owner);
		assertEquals(owner, board.getBoard()[6].getOwner());
	}

	
	/**
	 * Testing to update square 7 status
	 */
	@Test
	void testUpdateSquare7OwnedStatus() {
		owned = true;
		board.getBoard()[6].setOwned(owned);
		assertEquals(owned, board.getBoard()[6].isOwned());
	}

	
	/**
	 * Testing to update square 7 owned status
	 */
	@Test
	void testUpdateSquare7DevCount() {
		devCount = 1;
		board.getBoard()[6].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[6].getDevCount());
	}

	
	/**
	 * Testing to update square 7 owned status
	 */
	@Test
	void testUpdateSquare7CurrentRent() {
		currentRent = 200;
		board.getBoard()[6].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[6].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 8
	 */
	@Test
	void testGetBoardDetailsForSquare8() {
		squareName = "Oil";
		areaField = "Fossil Fuels";
		owner = null;
		owned = false;
		buyCost = 300;
		minDevCost = 150;
		majorDevCost = 300;
		rentNoDev = 15;
		rentOneDev = 30;
		rentTwoDev = 45;
		rentThreeDev = 60;
		rentMajorDev = 150;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[7].getSquareName());
		assertEquals(areaField, board.getBoard()[7].getAreaField());
		assertEquals(owner, board.getBoard()[7].getOwner());
		assertEquals(owned, board.getBoard()[7].isOwned());
		assertEquals(buyCost, board.getBoard()[7].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[7].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[7].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[7].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[7].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[7].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[7].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[7].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[7].getDevCount());
		assertEquals(currentRent, board.getBoard()[7].getCurrentRent());

	}

	
	/**
	 * Testing to update square 8 owner
	 */
	@Test
	void testUpdateSquare8Owner() {
		owner = "Mr Owner";
		board.getBoard()[7].setOwner(owner);
		assertEquals(owner, board.getBoard()[7].getOwner());

	}

	
	/**
	 * Testing to update square 8 owned status
	 */
	@Test
	void testUpdateSquare8OwnedStatus() {
		owned = true;
		board.getBoard()[7].setOwned(owned);
		assertEquals(owned, board.getBoard()[7].isOwned());
	}

	
	/**
	 * Testing to update square 8 owned status
	 */
	@Test
	void testUpdateSquare8DevCount() {
		devCount = 1;
		board.getBoard()[7].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[7].getDevCount());
	}

	
	/**
	 * Testing to update square 8 owned status
	 */
	@Test
	void testUpdateSquare8CurrentRent() {
		currentRent = 200;
		board.getBoard()[7].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[7].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 9
	 */
	@Test
	void testGetBoardDetailsForSquare9() {
		squareName = "Nuclear";
		areaField = "Renewable Energy";
		owner = null;
		owned = false;
		buyCost = 400;
		minDevCost = 200;
		majorDevCost = 400;
		rentNoDev = 40;
		rentOneDev = 70;
		rentTwoDev = 100;
		rentThreeDev = 125;
		rentMajorDev = 200;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[8].getSquareName());
		assertEquals(areaField, board.getBoard()[8].getAreaField());
		assertEquals(owner, board.getBoard()[8].getOwner());
		assertEquals(owned, board.getBoard()[8].isOwned());
		assertEquals(buyCost, board.getBoard()[8].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[8].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[8].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[8].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[8].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[8].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[8].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[8].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[8].getDevCount());
		assertEquals(currentRent, board.getBoard()[8].getCurrentRent());
	}

	
	/**
	 * Testing to update square 9 owner
	 */
	@Test
	void testUpdateSquare9Owner() {
		owner = "Mr Owner";
		board.getBoard()[8].setOwner(owner);
		assertEquals(owner, board.getBoard()[8].getOwner());
	}

	
	/**
	 * Testing to update square 9 owned status
	 */
	@Test
	void testUpdateSquare9OwnedStatus() {
		owned = true;
		board.getBoard()[8].setOwned(owned);
		assertEquals(owned, board.getBoard()[8].isOwned());
	}

	
	/**
	 * Testing to update square 9 owned status
	 */
	@Test
	void testUpdateSquare9DevCount() {
		devCount = 1;
		board.getBoard()[8].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[8].getDevCount());
	}

	
	/**
	 * Testing to update square 9 owned status
	 */
	@Test
	void testUpdateSquare9CurrentRent() {
		currentRent = 200;
		board.getBoard()[8].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[8].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 10
	 */
	@Test
	void testGetBoardDetailsForSquare10() {
		squareName = "Hydroelectric";
		areaField = "Renewable Energy";
		owner = null;
		owned = false;
		buyCost = 300;
		minDevCost = 150;
		majorDevCost = 300;
		rentNoDev = 15;
		rentOneDev = 30;
		rentTwoDev = 45;
		rentThreeDev = 60;
		rentMajorDev = 150;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[9].getSquareName());
		assertEquals(areaField, board.getBoard()[9].getAreaField());
		assertEquals(owner, board.getBoard()[9].getOwner());
		assertEquals(owned, board.getBoard()[9].isOwned());
		assertEquals(buyCost, board.getBoard()[9].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[9].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[9].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[9].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[9].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[9].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[9].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[9].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[9].getDevCount());
		assertEquals(currentRent, board.getBoard()[9].getCurrentRent());
	}

	
	/**
	 * Testing to update square 10 owner
	 */
	@Test
	void testUpdateSquare10Owner() {
		owner = "Mr Owner";
		board.getBoard()[9].setOwner(owner);
		assertEquals(owner, board.getBoard()[9].getOwner());
	}

	
	/**
	 * Testing to update square 10 owned status
	 */
	@Test
	void testUpdateSquare10OwnedStatus() {
		owned = true;
		board.getBoard()[9].setOwned(owned);
		assertEquals(owned, board.getBoard()[9].isOwned());
	}

	
	/**
	 * Testing to update square 10 owned status
	 */
	@Test
	void testUpdateSquare10DevCount() {
		devCount = 1;
		board.getBoard()[9].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[9].getDevCount());
	}

	
	/**
	 * Testing to update square 10 owned status via the board object.
	 */
	@Test
	void testUpdateSquare10CurrentRent() {
		currentRent = 200;
		board.getBoard()[9].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[9].getCurrentRent());
	}

	
	/**
	 * Testing the expected values for square 11
	 */
	@Test
	void testGetBoardDetailsForSquare11() {
		squareName = "Wind Energy";
		areaField = "Renewable Energy";
		owner = null;
		owned = false;
		buyCost = 100;
		minDevCost = 50;
		majorDevCost = 100;
		rentNoDev = 5;
		rentOneDev = 10;
		rentTwoDev = 15;
		rentThreeDev = 20;
		rentMajorDev = 50;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[10].getSquareName());
		assertEquals(areaField, board.getBoard()[10].getAreaField());
		assertEquals(owner, board.getBoard()[10].getOwner());
		assertEquals(owned, board.getBoard()[10].isOwned());
		assertEquals(buyCost, board.getBoard()[10].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[10].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[10].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[10].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[10].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[10].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[10].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[10].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[10].getDevCount());
		assertEquals(currentRent, board.getBoard()[10].getCurrentRent());
	}
	

	/**
	 * Testing to update square 11 owner
	 */
	@Test
	void testUpdateSquare11Owner() {
		owner = "Mr Owner";
		board.getBoard()[10].setOwner(owner);
		assertEquals(owner, board.getBoard()[10].getOwner());
	}

	
	/**
	 * Test to update square 11 owned status
	 */
	@Test
	void testUpdateSquare11OwnedStatus() {
		owned = true;
		board.getBoard()[10].setOwned(owned);
		assertEquals(owned, board.getBoard()[10].isOwned());
	}

	
	/**
	 * Test to update square 11 owned status
	 */
	@Test
	void testUpdateSquare11DevCount() {
		devCount = 1;
		board.getBoard()[10].setDevCount(devCount);
		assertEquals(devCount, board.getBoard()[10].getDevCount());
	}

	
	/**
	 * Test to update square 11 owned status
	 */
	@Test
	void testUpdateSquare11CurrentRent() {
		currentRent = 200;
		board.getBoard()[10].setCurrentRent(currentRent);
		assertEquals(currentRent, board.getBoard()[10].getCurrentRent());
	}
	
	
	/**
	 * Testing the expected values for square 12
	 */
	@Test
	void testGetBoardDetailsForSquare12() {
		squareName = "Rest";
		areaField = "ECO Base 2";
		owner = null;
		owned = false;
		buyCost = 0;
		minDevCost = 0;
		majorDevCost = 0;
		rentNoDev = 0;
		rentOneDev = 0;
		rentTwoDev = 0;
		rentThreeDev = 0;
		rentMajorDev = 0;
		devCount = 0;
		currentRent = 0;

		assertEquals(squareName, board.getBoard()[11].getSquareName());
		assertEquals(areaField, board.getBoard()[11].getAreaField());
		assertEquals(owner, board.getBoard()[11].getOwner());
		assertEquals(owned, board.getBoard()[11].isOwned());
		assertEquals(buyCost, board.getBoard()[11].getBuyCost());
		assertEquals(minDevCost, board.getBoard()[11].getMinDevCost());
		assertEquals(majorDevCost, board.getBoard()[11].getMajorDevCost());
		assertEquals(rentNoDev, board.getBoard()[11].getRentNoDev());
		assertEquals(rentOneDev, board.getBoard()[11].getRentOneDev());
		assertEquals(rentTwoDev, board.getBoard()[11].getRentTwoDev());
		assertEquals(rentThreeDev, board.getBoard()[11].getRentThreeDev());
		assertEquals(rentMajorDev, board.getBoard()[11].getRentMajorDev());
		assertEquals(devCount, board.getBoard()[11].getDevCount());
		assertEquals(currentRent, board.getBoard()[11].getCurrentRent());
	}

	// this is a rest square: no further testing required
	
}

