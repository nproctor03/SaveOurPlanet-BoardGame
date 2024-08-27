package saveOurPlanetDev;

public interface Field {
	
	public int getBuyCost();
	public String getFieldName();
	public int getMinDevCost();
	public void setMinDevCost(int minDevCost);
	public int getMajorDevCost();
	public void setMajorDevCost(int majorDevCost);
	public int getRentNoDev();
	public void setRentNoDev(int rentNoDev);
	public int getRentOneDev();
	public void setRentOneDev(int rentOneDev);
	public int getRentTwoDev();
	public void setRentTwoDev(int rentTwoDev);
	public int getRentThreeDev();
	public void setRentThreeDev(int rentThreeDev);
	public int getRentMajorDev();
	public void setRentMajorDev(int rentMajorDev);
	public void setBuyCost(int buyCost);

}
