package saveOurPlanetDev;

public class Player {
	
		// declare vars
		private String name;
		private int resourceBalance;
		private int currentPosition;
		
		
		//	default constructor
		public Player() {}
		
		
		// constructor with args
		public Player(String name, int resourceBalance, int currentPosition) {
			this.name = name;
			this.resourceBalance = resourceBalance;
			this.currentPosition = currentPosition;
		}
		
		
		// getters & setters to follow below		
		/**
		 * @return individual player name
		 */
		public String getName() {
			return name;
		}
		
		
		/**
		 * set player name
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		
		/**
		 * @return players resource balance
		 */
		public int getResourceBalance() {
			return resourceBalance;
		}
		
		
		/**
		 * set player resource balance
		 * @param resourceBalance
		 */
		public void setResourceBalance(int resourceBalance) {
			this.resourceBalance = resourceBalance;
		}
		
		
		/**
		 * @return current player position on game board
		 */
		public int getCurrentPosition() {
			return currentPosition;
		}
		
		
		/**
		 * set current player position on game board
		 * @param currentPosition
		 */
		public void setCurrentPosition(int currentPosition) {
			this.currentPosition = currentPosition;
		}

}  // end of class
