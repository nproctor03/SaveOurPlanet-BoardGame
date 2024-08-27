package saveOurPlanetDev;

public class Square{
	
	// declare & initialise static final vars
	
	// setting lower & upper vars for number of chars in "squareName"
	private static final int LOWER_VALID_SQUARENAME_LENGTH = 1;
	private static final int UPPER_VALID_SQUARENAME_LENGTH = 50;
	
	// setting lower & upper vars for number of chars in "owner"
	private static final int LOWER_VALID_OWNER_LENGTH = 1;
	private static final int UPPER_VALID_OWNER_LENGTH = 50;
	
	// setting lower & upper vars for "buyCost"
	private static final int LOWER_VALID_BUY_COST = 0;
	private static final int UPPER_VALID_BUY_COST = 1000;
	
	// setting lower & upper vars for "minDevCost"
	private static final int LOWER_VALID_MINDEV_COST = 0;
	private static final int UPPER_VALID_MINDEV_COST = 500;
	
	// setting lower & upper vars for "majorDevCost"
	private static final int LOWER_VALID_MAJORDEV_COST = 0;
	private static final int UPPER_VALID_MAJORDEV_COST = 500;
	
	// setting lower & upper vars for "rentNoDev"
	private static final int LOWER_VALID_RENT_NODEV = 0;
	private static final int UPPER_VALID_RENT_NODEV = 2000;
	
	// setting lower & upper vars for "rentOneDev"
	private static final int LOWER_VALID_RENT_ONEDEV = 0;
	private static final int UPPER_VALID_RENT_ONEDEV = 2000;
	
	// setting lower & upper vars for "rentTwoDev"
	private static final int LOWER_VALID_RENT_TWODEV = 0;
	private static final int UPPER_VALID_RENT_TWODEV = 2000;
	
	// setting lower & upper vars for "rentThreeDev"
	private static final int LOWER_VALID_RENT_THREEDEV = 0;
	private static final int UPPER_VALID_RENT_THREEDEV = 2000;
	
	// setting lower & upper vars for "rentMajorDev"
	private static final int LOWER_VALID_RENT_MAJORDEV = 0;
	private static final int UPPER_VALID_RENT_MAJORDEV = 2000;
	
	// setting lower & upper vars for "currentRent"
	private static final int LOWER_VALID_CURRENT_RENT = 0;
	private static final int UPPER_VALID_CURRENT_RENT = 2000;
	
	// setting lower & upper vars for "devCount"
	private static final int LOWER_VALID_DEV_COUNT = 0;
	private static final int UPPER_VALID_DEV_COUNT = 3;

	
	// declare vars
	private String squareName;
	private Field areaField;
	private String owner;
	private boolean owned;
	
	private boolean majorDev;
	private int devCount;
	private int currentRent;
	
	
	
	// default constructor
	public Square() {}
		
	
	// constructor with args
	/**
	 * @param squareName
	 * @param areaField
	 * @param owner
	 * @param owned
	 * @param devCount
	 * @param currentRent
	 */
	public Square(String squareName, Field areaField, String owner, boolean owned) {
		this.setSquareName(squareName);
		this.setAreaField(areaField);
		this.setOwner(owner);
		this.setOwned(owned);
		this.setDevCount(0);
		this.setCurrentRent(0);
	}

	
	// getters & setters
	
	
	/**
	 * @return square name
	 */
	public String getSquareName() {
		return squareName;
	}
	
	
	/**
	 * set square name
	 * throws illegal arg exception if chars outside allowable range
	 * 
	 * @param squareName: must be between 1-50 chars long	 
	 * @throws IllegalArgumentException
	 */
	public void setSquareName(String squareName) throws IllegalArgumentException{
		if (squareName.length()>=LOWER_VALID_SQUARENAME_LENGTH && squareName.length()<=UPPER_VALID_SQUARENAME_LENGTH){
			this.squareName = squareName;
		} else {
			throw new IllegalArgumentException("Invalid square name character length: must be between "+LOWER_VALID_SQUARENAME_LENGTH+"-"+UPPER_VALID_SQUARENAME_LENGTH+" chars long");
		}				
	}

	
	/**
	 * @return the area field
	 */
	public String getAreaField() {
		return this.areaField.getFieldName() ;
	}
	
	
	/**
	 * sets the area field.
	 * @throws IllegalArgumentException
	 */
	public void setAreaField(Field field) throws IllegalArgumentException{
		
		
		this.areaField = field; 
	}




	/**
	 * @return boolean for area if owned
	 */
	public boolean isOwned() {
		return owned;
	}
	
	
	/**
	 * sets owned attributes
	 * throws an illegal arg exception if not a boolean
	 * 
	 * @param owned : if area is currently owned, can only be true or false
	 * @throws IllegalArgumentException
	 */
	public void setOwned(boolean owned) throws IllegalArgumentException{
		if (owned==true || owned==false){
			this.owned = owned;
		} else {
			throw new IllegalArgumentException("Invalid owned value, can only be true or false");
		}		
	}

	
	/**
	 * @return the boolean isMajorDev
	 */
	public boolean isMajorDev() {
		return majorDev;
	}
	
	
	/**
	 * sets the majorDev attributes  
	 * throws an exception if not a boolean
	 * 
	 * @param isMajorDev: if the area currently has a major dev on it, must be true or false 
	 * @throws IllegalArgumentException
	 */
	public void setMajorDev(boolean majorDev) throws IllegalArgumentException{
		if (majorDev==true || majorDev==false){
			this.majorDev = majorDev;
		} else {
			throw new IllegalArgumentException("Invalid value for Major Dev, can only be true or false");
		}		
	}

	
	/**
	 * @return buyCost: area purchase cost
	 */
	public int getBuyCost() {
		return this.areaField.getBuyCost();
	}
	
	
	/**
	 * sets the buyCost var.
	 * if outside the allowable limits an illegal arg exception thrown
	 * 
	 * @param buyCost: cost to purchase the area, must be between 1 and 1000 
	 * @throws IllegalArgumentException
	 */
	public void setBuyCost(int buyCost) throws IllegalArgumentException{
		if (buyCost>=LOWER_VALID_BUY_COST && buyCost<=UPPER_VALID_BUY_COST){
			this.areaField.setBuyCost(buyCost);
		} else {
			throw new IllegalArgumentException("Invalid Buy Cost: must be between "+LOWER_VALID_BUY_COST+"-"+UPPER_VALID_BUY_COST);
		}				
	}
	

	/**
	 * @return minDevCost: cost to buy a minor dev
	 */
	public int getMinDevCost() {
		return this.areaField.getMinDevCost();
	}
	
	
	/**
	 * sets the minDevCost var
	 * throws an illegal arg exception if it is set outside the allowable limits
	 * 
	 * @param minDevCost: cost to buy a minor development, must be between 0-500 
	 * @throws IllegalArgumentException
	 */
	public void setMinDevCost(int minDevCost) throws IllegalArgumentException{
		if (minDevCost>=LOWER_VALID_MINDEV_COST && minDevCost<=UPPER_VALID_MINDEV_COST){
			this.areaField.setMinDevCost(minDevCost);
		} else {
			throw new IllegalArgumentException("Invalid Min Dev Cost: must be between "+LOWER_VALID_MINDEV_COST+"-"+UPPER_VALID_MINDEV_COST);
		}				
	}


	/**
	 * @return majorDevCost: cost to buy a major dev
	 */
	public int getMajorDevCost() {
		return this.areaField.getMajorDevCost();
	}
	
	/**
	 * sets the majorDevCost var
	 * throws an illegal arg exception if it is set outside the allowable limits
	 * 
	 * @param majorDevCost: cost to buy a minor dev, must be between 0 and 500 
	 * @throws IllegalArgumentException
	 */
	public void setMajorDevCost(int majorDevCost) throws IllegalArgumentException{
		if (majorDevCost>=LOWER_VALID_MAJORDEV_COST && majorDevCost<=UPPER_VALID_MAJORDEV_COST){
			this.areaField.setMajorDevCost(majorDevCost);
		} else {
			throw new IllegalArgumentException("Invalid Major Dev Cost: must be between "+LOWER_VALID_MAJORDEV_COST+"-"+UPPER_VALID_MAJORDEV_COST);
		}				
	}


	/**
	 * @return rentNoDev: the rent when the area is owned but has no dev on it
	 */
	public int getRentNoDev() {
		return this.areaField.getRentNoDev();
	}
	
	
	/**
	 * sets rentNoDev var
	 * throws an illegal arg exception if it is set outside the allowable limits
	 * 
	 * @param rentNoDev: rent for an area with no dev on it, must be between 0 and 2000 
	 * @throws IllegalArgumentException
	 */
	public void setRentNoDev(int rentNoDev) throws IllegalArgumentException{
		if (rentNoDev>=LOWER_VALID_RENT_NODEV && rentNoDev<=UPPER_VALID_RENT_NODEV){
			this.areaField.setRentNoDev(rentNoDev);
		} else {
			throw new IllegalArgumentException("Invalid Rent No Dev: must be between "+LOWER_VALID_RENT_NODEV+"-"+UPPER_VALID_RENT_NODEV);
		}				
	}


	/**
	 * @return rentOneDev: the rent when there is one minor dev on an area
	 */
	public int getRentOneDev() {
		return this.areaField.getRentOneDev();
	}
	
	
	/**
	 * sets the rentOneDev var
	 * throws an illegal arg exception if it is set outside the allowable limits
	 * 
	 * @param rentOneDev: rent for an area with one dev on it, must be between 0 and 2000 
	 * @throws IllegalArgumentException
	 */
	public void setRentOneDev(int rentOneDev) throws IllegalArgumentException{
		if (rentOneDev>=LOWER_VALID_RENT_ONEDEV && rentOneDev<=UPPER_VALID_RENT_ONEDEV){
			this.areaField.setRentOneDev(rentOneDev);
		} else {
			throw new IllegalArgumentException("Invalid Rent One Dev: must be between "+LOWER_VALID_RENT_ONEDEV+"-"+UPPER_VALID_RENT_ONEDEV);
		}				
	}


	/**
	 * @return rentTwoDev: the rent when there is two minor devs on area
	 */
	public int getRentTwoDev() {
		return this.areaField.getRentTwoDev();
	}
	
	
	/**
	 * sets the rentTwoDev var
	 * throws an illegal arg exception if it is set outside the allowable limits
	 * 
	 * @param rentTwoDev: rent for an area with two minor devs on it, must be between 0 and 2000
	 * @throws IllegalArgumentException
	 */
	public void setRentTwoDev(int rentTwoDev) throws IllegalArgumentException{
		if (rentTwoDev>=LOWER_VALID_RENT_TWODEV && rentTwoDev<=UPPER_VALID_RENT_TWODEV){
			this.areaField.setRentTwoDev(rentTwoDev);
		} else {
			throw new IllegalArgumentException("Invalid Rent Two Dev: must be between "+LOWER_VALID_RENT_TWODEV+"-"+UPPER_VALID_RENT_TWODEV);
		}				
	}


	/**
	 * @return rentThreeDev: the rent when there is two minor devs on an area
	 */
	public int getRentThreeDev() {
		return this.areaField.getRentThreeDev();
	}
	
	/**
	 * sets the rentThreeDev var
	 * throws an exception if it is set outside the allowable limits
	 * 
	 * @param rentThreeDev: rent for an area with three minor devs on it, must be between 0-2000 
	 * @throws IllegalArgumentException
	 */
	public void setRentThreeDev(int rentThreeDev) throws IllegalArgumentException{
		if (rentThreeDev>=LOWER_VALID_RENT_THREEDEV && rentThreeDev<=UPPER_VALID_RENT_THREEDEV){
			this.areaField.setRentThreeDev(rentThreeDev);
		} else {
			throw new IllegalArgumentException("Invalid Rent Three Dev: must be between "+LOWER_VALID_RENT_THREEDEV+"-"+UPPER_VALID_RENT_THREEDEV);
		}			
	}


	/**
	 * @return rentMajorDev: The rent when there is three minor devs on area
	 */
	public int getRentMajorDev() {
		return this.areaField.getRentMajorDev();
	}
	
	
	/**
	 * sets the rentMajorDev variable
	 * throws an illegal arg exception if set outside  allowable range
	 * 
	 * @param rentMajorDev: rent for an area with three minor devs on it, must be between 0 and 2000
	 * @throws IllegalArgumentException
	 */
	public void setRentMajorDev(int rentMajorDev) throws IllegalArgumentException{
		if (rentMajorDev>=LOWER_VALID_RENT_MAJORDEV && rentMajorDev<=UPPER_VALID_RENT_MAJORDEV){
			this.areaField.setRentMajorDev(rentMajorDev);
		} else {
			throw new IllegalArgumentException("Invalid Rent Major Dev: must be between "+LOWER_VALID_RENT_MAJORDEV+"-"+UPPER_VALID_RENT_MAJORDEV);
		}				
	}


	/**
	 * @return the owner for the square
	 */
	public String getOwner() {
		return owner;
	}
	
	
	/**
	 * sets the owner of the square
	 * throws an illegal arg exception if the number of chars is outside allowable range
	 * 
	 * @param owner: must between 1 and 50 chars long
	 * @throws IllegalArgumentException
	 */
	public void setOwner(String owner) throws IllegalArgumentException{
		if (owner == null || (owner.length()>=LOWER_VALID_OWNER_LENGTH && owner.length()<=UPPER_VALID_OWNER_LENGTH)){
			this.owner = owner;
		} else {
			throw new IllegalArgumentException("Invalid owner character length: must be between "+LOWER_VALID_OWNER_LENGTH+"-"
					+UPPER_VALID_OWNER_LENGTH+" chars long");
		}				
	}

	
	/**
	 * @return devCount: the number of devs currently
	 */
	public int getDevCount() {
		return devCount;
	}
	
	/**
	 * sets the devCount var
	 * throws an illegal arg exception if set outside allowable range
	 * 
	 * @param devCount: sets the number of current devs
	 * @throws IllegalArgumentException
	 */
	public void setDevCount(int devCount) throws IllegalArgumentException{
		if (devCount>=LOWER_VALID_DEV_COUNT && devCount<=UPPER_VALID_DEV_COUNT){
			this.devCount = devCount;
		} else {
			throw new IllegalArgumentException("Invalid Dev Count: must be between "+LOWER_VALID_DEV_COUNT+"-"+UPPER_VALID_DEV_COUNT);
		}				
	}

	
	/**
	 * @return currentRent: get current rent of area
	 */
	public int getCurrentRent() {
		return currentRent;
	}
	
	
	/**
	 * sets the currentRent var
	 * throws an illegal arg exception if it is set outside  allowable range
	 * 
	 * @param currentRent: current rent for the area, must be between 0 and 2000
	 * @throws IllegalArgumentException
	 */
	public void setCurrentRent(int currentRent) throws IllegalArgumentException{
		if (currentRent>=LOWER_VALID_CURRENT_RENT && currentRent<=UPPER_VALID_CURRENT_RENT){
			this.currentRent = currentRent;
		} else {
			throw new IllegalArgumentException("Invalid Current Rent: must be between "+LOWER_VALID_CURRENT_RENT+"-"+UPPER_VALID_CURRENT_RENT);
		}				
	}

} // end of class
