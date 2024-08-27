package saveOurPlanetDev;

public class Technology implements Field {
	
	private String fieldName = "Technology";
	private int buyCost = 300;
	

	private int minDevCost = 150;
	private int majorDevCost = 300;
	private int rentNoDev = 15;
	private int rentOneDev = 30;
	private int rentTwoDev = 45;
	private int rentThreeDev = 60;
	private int rentMajorDev = 150;
	
	public Technology() {
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
