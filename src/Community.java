package saveOurPlanetDev;

public  class Community implements Field {
	
	private String fieldName = "Community";
	private int buyCost = 100;
	

	private int minDevCost = 50;
	private int majorDevCost = 100;
	private int rentNoDev = 5;
	private int rentOneDev = 10;
	private int rentTwoDev = 15;
	private int rentThreeDev = 20;
	private int rentMajorDev = 50;
	
	public Community() {
		super();
	}

	public void setBuyCost(int buyCost) {
		this.buyCost = buyCost;
	}

	public int getBuyCost() {
		return buyCost;
	}

	public String getFieldName() {
		return fieldName;

}

	public int getMinDevCost() {
		return minDevCost;
	}

	public void setMinDevCost(int minDevCost) {
		this.minDevCost = minDevCost;
	}

	public int getMajorDevCost() {
		return majorDevCost;
	}

	public void setMajorDevCost(int majorDevCost) {
		this.majorDevCost = majorDevCost;
	}

	public int getRentNoDev() {
		return rentNoDev;
	}

	public void setRentNoDev(int rentNoDev) {
		this.rentNoDev = rentNoDev;
	}

	public int getRentOneDev() {
		return rentOneDev;
	}

	public void setRentOneDev(int rentOneDev) {
		this.rentOneDev = rentOneDev;
	}

	public int getRentTwoDev() {
		return rentTwoDev;
	}

	public void setRentTwoDev(int rentTwoDev) {
		this.rentTwoDev = rentTwoDev;
	}

	public int getRentThreeDev() {
		return rentThreeDev;
	}

	public void setRentThreeDev(int rentThreeDev) {
		this.rentThreeDev = rentThreeDev;
	}

	public int getRentMajorDev() {
		return rentMajorDev;
	}

	public void setRentMajorDev(int rentMajorDev) {
		this.rentMajorDev = rentMajorDev;
	}
	
}
