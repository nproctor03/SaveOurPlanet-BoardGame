package saveOurPlanetDev;

public class Start implements Field {
	
	private String fieldName = "Start";
	private int buyCost = 0;
	

	private int minDevCost = 0;
	private int majorDevCost = 0;
	private int rentNoDev = 200;
	private int rentOneDev = 0;
	private int rentTwoDev = 0;
	private int rentThreeDev = 0;
	private int rentMajorDev = 0;

	@Override
	public int getBuyCost() {
		// TODO Auto-generated method stub
		return this.buyCost;
	}

	@Override
	public String getFieldName() {
		// TODO Auto-generated method stub
		return this.fieldName;
	}

	@Override
	public int getMinDevCost() {
		// TODO Auto-generated method stub
		return this.minDevCost;
	}

	@Override
	public void setMinDevCost(int minDevCost) {
		this.minDevCost =0;

	}

	@Override
	public int getMajorDevCost() {
		// TODO Auto-generated method stub
		return this.majorDevCost;
	}

	@Override
	public void setMajorDevCost(int majorDevCost) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRentNoDev() {
		// TODO Auto-generated method stub
		return this.rentNoDev;
	}

	@Override
	public void setRentNoDev(int rentNoDev) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRentOneDev() {
		// TODO Auto-generated method stub
		return this.rentOneDev;
	}

	@Override
	public void setRentOneDev(int rentOneDev) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRentTwoDev() {
		// TODO Auto-generated method stub
		return this.rentTwoDev;
	}

	@Override
	public void setRentTwoDev(int rentTwoDev) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRentThreeDev() {
		// TODO Auto-generated method stub
		return this.rentThreeDev;
	}

	@Override
	public void setRentThreeDev(int rentThreeDev) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRentMajorDev() {
		// TODO Auto-generated method stub
		return this.rentMajorDev;
	}

	@Override
	public void setRentMajorDev(int rentMajorDev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBuyCost(int buyCost) {
		// TODO Auto-generated method stub

	}

}
