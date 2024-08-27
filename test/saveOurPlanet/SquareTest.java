package saveOurPlanet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saveOurPlanet.Square;


/**
 * Testing square class
 */
class SquareTest {	
	// declaring vars for squareName testing
	String validSquareNameCharLength;
	String invalidSquareNameCharLength;
	String invalidSquareNameMessage;
	
	// declaring vars for areaField testing
	String validAreaFieldCharLength;
	String invalidAreaFieldCharLength;
	String invalidAreaFieldMessage;
	
	// declaring vars for owner testing
	String validOwnerCharLength;
	String invalidOwnerCharLength;
	String invalidOwnerMessage;
	
	// declaring vars for buyCost testing
	int validBuyCost;
	int invalidBuyCost;
	String invalidBuyCostMessage;
	
	// declaring vars for minDevCost testing
	int validMinDevCost;
	int invalidMinDevCost;
	String invalidMinDevCostMessage;
	
	// declaring vars for majorDevCost testing
	int validMajorDevCost;
	int invalidMajorDevCost;
	String invalidMajorDevCostMessage;
	
	// declaring vars for owned testing
	boolean validOwned;
	String invalidOwned;
	
	// declaring vars for rentNoDev testing
	int validRentNoDev;
	int invalidRentNoDev;
	String invalidRentNoDevMessage;
	
	// declaring  vars for rentOneDev testing
	int validRentOneDev;
	int invalidRentOneDev;
	String invalidRentOneDevMessage;
	
	// declaring  vars for rentTwoDev testing
	int validRentTwoDev;
	int invalidRentTwoDev;
	String invalidRentTwoDevMessage;

	// declaring vars for rentThreeDev testing
	int validRentThreeDev;
	int invalidRentThreeDev;
	String invalidRentThreeDevMessage;
	
	// declaring vars for rentmajorDev testing
	int validRentMajorDev;
	int invalidRentMajorDev;
	String invalidRentMajorDevMessage;
	
	// declaring vars for currentRent testing
	int validCurrentRent;
	int invalidCurrentRent;
	String invalidCurrentRentMessage;
	
	// declaring vars for devCount testing
	int validDevCount;
	int invalidDevCount;
	String invalidDevCountMessage;


	// Preparing test environment
	@BeforeEach
	void setUp() throws Exception {		
	// initialising vars for squareName testing
	validSquareNameCharLength = "Square Name";
	invalidSquareNameCharLength = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	invalidSquareNameMessage = "Invalid square name character length: must be between 1-50 chars long";
	
	// initialising vars for areaField testing
	validAreaFieldCharLength = "Renewable Energy";
	invalidAreaFieldCharLength =  "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	invalidAreaFieldMessage = "Invalid area field length: must be between 1-50 chars long";
	
	// initialising vars for owner testing
	validOwnerCharLength = "New Player";
	invalidOwnerCharLength =  "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
	invalidOwnerMessage = "Invalid owner character length: must be between 1-50 chars long";
	
	// initialising vars for costBuy testing
	validBuyCost = 100;
	invalidBuyCost = 5000;
	invalidBuyCostMessage = "Invalid Buy Cost: must be between 0-1000";
	
	// initialising vars for minDevcost testing
	validMinDevCost = 100;
	invalidMinDevCost = 1000;
	invalidMinDevCostMessage= "Invalid Min Dev Cost: must be between 0-500";
	
	// initialising vars for majorDevCost testing
	validMajorDevCost = 100;
	invalidMajorDevCost = 1000;
	invalidMajorDevCostMessage = "Invalid Major Dev Cost: must be between 0-500";
	
	// initialising vars for owned testing
	validOwned = true;
	invalidOwned = "No";		
	
	// initialising vars for rentNoDev testing
	validRentNoDev = 100;
	invalidRentNoDev = 3000;
	invalidRentNoDevMessage = "Invalid Rent No Dev: must be between 0-2000";
	
	// initialising vars for rentOneDev testing
	validRentOneDev = 100;
	invalidRentOneDev = 3000;
	invalidRentOneDevMessage = "Invalid Rent One Dev: must be between 0-2000";
	
	// initialising vars for rentTwoDev testing
	validRentTwoDev = 100;
	invalidRentTwoDev = 3000;
	invalidRentTwoDevMessage = "Invalid Rent Two Dev: must be between 0-2000";
	
	// initialising vars for rentThreeDev testing
	validRentThreeDev = 100;
	invalidRentThreeDev = 3000;
	invalidRentThreeDevMessage = "Invalid Rent Three Dev: must be between 0-2000";
	
	// initialising vars for rentMajorDev testing
	validRentMajorDev = 100;
	invalidRentMajorDev =3000;
	invalidRentMajorDevMessage = "Invalid Rent Major Dev: must be between 0-2000";
	
	// initialising vars for currentRent testing
	validCurrentRent = 100;
	invalidCurrentRent = 3000;
	invalidCurrentRentMessage = "Invalid Current Rent: must be between 0-2000";
	
	// initialising vars for devCount testing
	validDevCount =1;
	invalidDevCount=5;
	invalidDevCountMessage = "Invalid Dev Count: must be between 0-3";	
	}
	
	
	/**
	 * Testing the squareConstructorArgs with valid values
	 */
	@Test
	public void testSquareContructorArgs() {
		Square newSquare = new Square(validSquareNameCharLength, validAreaFieldCharLength, validOwnerCharLength, validOwned,
				validBuyCost, validMinDevCost, validMajorDevCost, validRentNoDev,
				validRentOneDev, validRentTwoDev, validRentThreeDev,
				validRentMajorDev, validDevCount, validCurrentRent);

		assertEquals(validSquareNameCharLength, newSquare.getSquareName());
		assertEquals(validAreaFieldCharLength, newSquare.getAreaField());
		assertEquals(validOwnerCharLength, newSquare.getOwner());
		assertEquals(validOwned, newSquare.isOwned());
		assertEquals(validBuyCost, newSquare.getBuyCost());
		assertEquals(validMinDevCost, newSquare.getMinDevCost());
		assertEquals(validMajorDevCost, newSquare.getMajorDevCost());
		assertEquals(validRentNoDev, newSquare.getRentNoDev());
		assertEquals(validRentOneDev, newSquare.getRentOneDev());
		assertEquals(validRentTwoDev, newSquare.getRentTwoDev());
		assertEquals(validRentThreeDev, newSquare.getRentThreeDev());
		assertEquals(validRentMajorDev, newSquare.getRentMajorDev());
		assertEquals(validDevCount, newSquare.getDevCount());
		assertEquals(validCurrentRent, newSquare.getCurrentRent());
	}
	
	
	/**
	 * Testing squareConstructorArgs throws illegal arg exception with invalid values
	 */
	@Test
	public void testSquareConstructorInvalidArgs() {
				IllegalArgumentException illegalArgumentExceptionYear = assertThrows(IllegalArgumentException.class, () -> {
			Square newSquare = new Square(validSquareNameCharLength, validAreaFieldCharLength, validOwnerCharLength, validOwned,
					invalidBuyCost, validMinDevCost, validMajorDevCost, validRentNoDev,
					validRentOneDev, validRentTwoDev, validRentThreeDev,
					validRentMajorDev, validDevCount, validCurrentRent);
		});
		// Testing exception message
		assertEquals(invalidBuyCostMessage, illegalArgumentExceptionYear.getMessage());		
	}
	
	
	/**
	 * Testing squareName getter and setter with valid values
	 */
	@Test
	void testValidSquareName() {
		Square newSquare = new Square();
		newSquare.setSquareName(validSquareNameCharLength);
		assertEquals(validSquareNameCharLength, newSquare.getSquareName());
	}
	

	/**
	 * Testing squareName throws exception with invalid values
	 */
	@Test
	void testInvalidSquareName() {

		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setSquareName(invalidSquareNameCharLength);
		});		
		// Testing exception message
		assertEquals(invalidSquareNameMessage, illegalArgumentException.getMessage());		
	}
	
	
	/**
	 * Testing areaField getter and setter with valid values
	 */
	@Test
	void testValidAreaField() {
		Square newSquare = new Square();
		newSquare.setAreaField(validAreaFieldCharLength);
		assertEquals(validAreaFieldCharLength, newSquare.getAreaField());
	}
	

	/**
	 * Testing areaField throws exception with invalid values
	 */
	@Test
	void testInvalidAreaField() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setAreaField(invalidAreaFieldCharLength);
		});		
		// Testing exception message
		assertEquals(invalidAreaFieldMessage, illegalArgumentException.getMessage());		
	}
	
	
	/**
	 * Testing owner getter and setter with valid values
	 */
	@Test
	void testValidOwner() {
		Square newSquare = new Square();
		newSquare.setOwner(validOwnerCharLength);
		assertEquals(validOwnerCharLength, newSquare.getOwner());
	}

	
	/**
	 * Testing owner throws exception with invalid values
	 */
	@Test
	void testInvalidOwner() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setOwner(invalidOwnerCharLength);
		});		
		// Testing exception message
		assertEquals(invalidOwnerMessage, illegalArgumentException.getMessage());		
	}

	
	/**
	 * Testing buyCost getter and setter with valid values
	 */
	@Test
	void testValidBuyCost() {
		Square newSquare = new Square();
		newSquare.setBuyCost(validBuyCost);
		assertEquals(validBuyCost, newSquare.getBuyCost());
	}
	

	/**
	 * Testing buyCost throws exception with invalid values
	 */
	@Test
	void testInvalidBuyCost() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setBuyCost(invalidBuyCost);
		});		
		// Testing exception message
		assertEquals(invalidBuyCostMessage, illegalArgumentException.getMessage());		
	}

	
	/**
	 * Testing minDevCost getter and setter with valid values
	 */
	@Test
	void testValidMinDevCost() {
		Square newSquare = new Square();
		newSquare.setMinDevCost(validMinDevCost);
		assertEquals(validMinDevCost, newSquare.getMinDevCost());
	}
	

	/**
	 * Testing minDevCost throws exception with invalid values
	 */
	@Test
	void testInvalidMinDevCost() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setMinDevCost(invalidMinDevCost);
		});		
		// Testing exception message
		assertEquals(invalidMinDevCostMessage, illegalArgumentException.getMessage());		
	}
	
	
	/**
	 * Testing majorDevCost getter and setter with valid values
	 */
	@Test
	void testValidMajorDevCost() {
		Square newSquare = new Square();
		newSquare.setMajorDevCost(validMajorDevCost);
		assertEquals(validMajorDevCost, newSquare.getMajorDevCost());
	}

	
	/**
	 * Testing majorDevCost throws exception with invalid values
	 */
	@Test
	void testInvalidMajorDevCost() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setMajorDevCost(invalidMajorDevCost);
		});		
		// Testing exception message
		assertEquals(invalidMajorDevCostMessage, illegalArgumentException.getMessage());		
	}
	
	
	/**
	 * Testing rentNoDev getter and setter with valid values
	 */
	@Test
	void testValidRentNoDev() {
		Square newSquare = new Square();
		newSquare.setRentNoDev(validRentNoDev);
		assertEquals(validRentNoDev, newSquare.getRentNoDev());
	}

	
	/**
	 * Testing rentNoDev throws exception with invalid values
	 */
	@Test
	void testInvalidRentNoDev() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setRentNoDev(invalidRentNoDev);
		});		
		// Testing exception message
		assertEquals(invalidRentNoDevMessage, illegalArgumentException.getMessage());
		
	}
	
	
	/**
	 * Testing rentOneDev getter and setter with valid values
	 */
	@Test
	void testValidRentOneDev() {
		Square newSquare = new Square();
		newSquare.setRentOneDev(validRentOneDev);
		assertEquals(validRentOneDev, newSquare.getRentOneDev());
	}

	
	/**
	 * Testing rentOneDev throws exception with invalid values
	 */
	@Test
	void testInvalidRentOneDev() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setRentOneDev(invalidRentOneDev);
		});		
		// Testing exception message
		assertEquals(invalidRentOneDevMessage, illegalArgumentException.getMessage());
		
	}
	
	
	/**
	 * Testing rentTwoDev getter and setter with valid values
	 */
	@Test
	void testValidRentTwoDev() {
		Square newSquare = new Square();
		newSquare.setRentTwoDev(validRentTwoDev);
		assertEquals(validRentTwoDev, newSquare.getRentTwoDev());
	}

	
	/**
	 * Testing rentTwoDev throws exception with invalid values
	 */
	@Test
	void testInvalidRentTwoDev() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setRentTwoDev(invalidRentTwoDev);
		});		
		// Testing exception message
		assertEquals(invalidRentTwoDevMessage, illegalArgumentException.getMessage());
		
	}
	
	
	/**
	 * Testing rentThreeDev getter and setter with valid values
	 */
	@Test
	void testValidRentThreeDev() {
		Square newSquare = new Square();
		newSquare.setRentThreeDev(validRentThreeDev);
		assertEquals(validRentThreeDev, newSquare.getRentThreeDev());

	}

	
	/**
	 * Testing rentThreeDev throws exception with invalid values
	 */
	@Test
	void testInvalidRentThreeDev() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setRentThreeDev(invalidRentThreeDev);
		});		
		// Testing exception message
		assertEquals(invalidRentThreeDevMessage, illegalArgumentException.getMessage());
		
	}
	
	
	/**
	 * Testing rentMajorDev getter and setter with valid values
	 */
	@Test
	void testValidRentMajorDev() {
		Square newSquare = new Square();
		newSquare.setRentMajorDev(validRentMajorDev);
		assertEquals(validRentMajorDev, newSquare.getRentMajorDev());

	}

	
	/**
	 * Testing rentMajorDev throws exception with invalid values
	 */
	@Test
	void testInvalidRentMajorDev() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setRentMajorDev(invalidRentMajorDev);
		});		
		// Testing exception message
		assertEquals(invalidRentMajorDevMessage, illegalArgumentException.getMessage());
		
	}
	
	
	/**
	 * Testing currentRent getter and setter with valid values
	 */
	@Test
	void testValidCurrentRent() {
		Square newSquare = new Square();
		newSquare.setCurrentRent(validCurrentRent);
		assertEquals(validCurrentRent, newSquare.getCurrentRent());

	}

	
	/**
	 * Testing currentRent throws exception with invalid values
	 */
	@Test
	void testInvalidCurrentRent() {
		Square newSquare = new Square();
		IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setCurrentRent(invalidCurrentRent);
		});		
		// Testing exception message
		assertEquals(invalidCurrentRentMessage, illegalArgumentException.getMessage());
		
	}
	
	
	/**
	 * Testing devCount getter and setter with valid values
	 */
	@Test
	void testValidDevCount() {
		Square newSquare = new Square();
		newSquare.setDevCount(validDevCount);
		assertEquals(validDevCount, newSquare.getDevCount());

	}

	
	/**
	 * Testing devCount throws exception with invalid values
	 */
	@Test
	void testInvalidDevCount() {
		Square newSquare = new Square();
				IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
			newSquare.setDevCount(invalidDevCount);
		});		
		// Testing exception message
		assertEquals(invalidDevCountMessage, illegalArgumentException.getMessage());		
	}

}
