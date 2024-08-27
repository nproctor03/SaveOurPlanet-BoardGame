package saveOurPlanetDev;

import java.util.*;

public class MainGame {

	// vars
	private static Map<Integer, Square> squarePosition = new HashMap<Integer, Square>();
	private static ArrayList<Player> players = new ArrayList<Player>();
	public static boolean quitGame = false;
	final static int maxPlayers = 4;
	final static int dramaticPause = 500;

	// main method
	public static void main(String[] args) {
		Board board = new Board();

		for (int i = 0; i < board.getBoard().length; i++) {
			squarePosition.put((i), board.getBoard()[(i)]);
		}

		Scanner input = new Scanner(System.in);
		input.useDelimiter(System.lineSeparator());

		int totalPlayers = 0;
		boolean OK = false;

		
		// start the game
		System.out.println(
				"Hello, welcome to the 'Save Our Planet' Board Game.");
		System.out.println(
				"How many players are taking part? (please enter a number between 1 - 4)");		
		
		// enter players quantity and validate
		do {
			try {
				totalPlayers = input.nextInt();
				OK = true;
			} catch (Exception e) {
				System.out.println("Sorry, thats wrong. Please enter a 'number'..... between 1 - 4.");
				OK = false;
				input.next();
			}
		} while (!OK);

		// ensure number of players is between 1 and 4: then validate
		while (totalPlayers < 1 || totalPlayers > maxPlayers) {
			do {
				try {
					System.out
							.println("The number of players must be between 1 - " + maxPlayers + ". Please try again.");
					totalPlayers = input.nextInt();
					OK = true;
				} catch (Exception e) {
					System.out.println("Sorry, you must enter a number");
					OK = false;
					input.next();
				}
			} while (!OK);
		}

		String playerName;

		// add players and assign their names
		for (int i = 0; i < totalPlayers; i++) {
			do {
				System.out.print("Please enter the name for player " + (i+1) + ": ");
				
				playerName = input.next();
				while (playerName.isEmpty() || playerName.matches("[0-9]+")) {
					System.out.println("You must enter a name (a-z / A-Z)");
					playerName = input.next();
				}
				//ensure the name entered isn't already in use from another player
				for (int j = 0; j < players.size(); j++) {
					if (players.get(j).getName().equalsIgnoreCase(playerName)) {
						System.out.println("That name's already taken. Please choose another.");
						OK = false;
						break;
					} else {
						OK = true;
					}
				}

			} while (!OK);
			
			players.add(new Player(playerName, 1000, 0));
			input.nextLine();
				
		}
		
		// Display players
		System.out.println("Thank you. \n");
		System.out.println("Today's players are: \n");
		viewPlayerStatus(players);

		int option = 0;
		int rollAttempt = 0;
		boolean endTurn = false;
		boolean missionAccomplished = false;

		do {
			for (int i = 0; i < totalPlayers; i++) {
				if (quitGame == true) {
					break;
				}
				do {
					endTurn = false;
					if (missionAccomplished == true) {
						quitGame = true;
					}
					
					System.out.println();
					System.out.println("Roller roller, step right up.....");
					
					// Ask player to pick an option for their turn
					do {
						try {
							System.out.println();
							System.out.println(players.get(i).getName() + " - your current ECO Coin balance is "
									+ players.get(i).getResourceBalance() + ".");
//							System.out.println("The game is now starting.....\n");
							displayOptions();
							option = input.nextInt();
							OK = true;
						} catch (Exception e) {
							System.out.println("Sorry, please enter the corresponding number.");
							OK = false;
							input.next();
						}
					} while (!OK);

					switch (option) {

					case 1:
						// Roll the dice
						if (rollAttempt < 1) {
							quitGame = diceOutcome(players.get(i), board.getBoard(), input, quitGame);
							rollAttempt++;
							break;
						} else {
							System.out.println("Sorry, you can only roll the dice once per turn.");
							System.out.print("Please press enter to continue.....");
							input.nextLine();
							input.nextLine();
							break;
						}
					case 2:
						// Build a minor dev 
						quitGame = buildMinorDev(players.get(i), board.getBoard(), input);
						break;
					case 3:
						// Build a major dev
						quitGame = buildMajorDev(players.get(i), board.getBoard(), input);
						missionAccomplished = boardComplete(board.getBoard());
						break;
					case 4:
						// Skip or end current player turn
						System.out.println("Your turn has finished.");
						endTurn = true;
						rollAttempt = 0;
						break;
					case 5:
						// View player status
						viewPlayerStatus(players);
						System.out.println();
						System.out.print("Please press enter to continue..");
						input.nextLine();
						input.nextLine();
						break;
					case 6:
						// View Board Status
						viewBoardStatus(board.getBoard());
						System.out.println();
						System.out.print("Please press enter to continue..");
						input.nextLine();
						input.nextLine();
						break;
					case 7:
						// Quit game
						boolean validChoiceQuitGame = false;
						String quitChoice;

						// Double check quit game selection
						do {
							System.out.println(
									"Are you sure you want to quit? The game will be ended for everyone? Please Enter Y or N");

							quitChoice = input.next();

							if (quitChoice.equalsIgnoreCase("Y") || quitChoice.equalsIgnoreCase("N")) {
								validChoiceQuitGame = true;
							} else {
								System.out.println("Your selection must be either Y or N.");
							}

						} while (!validChoiceQuitGame);

						if (quitChoice.equalsIgnoreCase("Y")) {
							quitGame = quitGame();
						}
						rollAttempt = 0;
						endTurn = true;
						break;
					default:
						System.out.println("Sorry, incorrect selection. Please choose your option between 1 - 7");
					}

				} while (endTurn == false && quitGame == false);
			}

		} while (quitGame == false);

		if (quitGame == true) {
			// If successful mission display game completed message
			if (missionAccomplished == true) {
				System.out.println("You have successfully completed the ECO Mission and saved our planet");
				viewPlayerStatus(players);
				System.out.println();
				viewBoardStatus(board.getBoard());
				System.out.println();
				successfulEcoMission(players);
			} else {
				// If unsuccessful display game failed message
				failedEcoMission(board, players);
			}

		}

	} // End of main method

	/**
	 * Outcomes offered after rolling dice
	 * @param player
	 * @param squares
	 * @param input
	 * @param quitGame
	 * @return
	 */
	public static boolean diceOutcome(Player player, Square[] squares, Scanner input, boolean quitGame) {
		boolean OK = false;
		quitGame = false;
		// Dice roll
		int dice1 = rollDice();
		int dice2 = rollDice();
		int roll = dice1 + dice2;

		// Display  square player is currently on
		int currentPosition = player.getCurrentPosition();
		System.out.println(player.getName() + ", the square you are currently on is " + squares[currentPosition].getSquareName()
				+ " within " + squares[currentPosition].getAreaField() + ".");
		try {
			System.out.println("Rolling dice.....");
			Thread.sleep(dramaticPause);
		} catch (InterruptedException e) {
			System.out.println("Interruption: diceOutcome method.");
			System.out.flush();
		}

		// Show result of dice roll and total
		System.out.println(
				player.getName() + ", you have rolled a " + dice1 + " and a " + dice2 + " totalling " + roll + ".");
		int newPosition = currentPosition + roll;

		// Check is total is greater than 12 to 'collect 200 pass go' funding (start square in our game)
		if (newPosition >= 12) {
			int currentResources = player.getResourceBalance();
			int passGoMoney = 200;
			int updatedResources = currentResources + passGoMoney;
			player.setResourceBalance(updatedResources);
			System.out
					.println("You have collected 200 additional ECO Coins for passing the Start Sqaure. Your new ECO Coin balance is "
							+ updatedResources + ".");
			newPosition = newPosition - 12;
		}

		// Check what square the player has landed on
		if (squarePosition.containsKey(roll - 1)) {
			for (int i = 0; i < squares.length; i++) {
				if (i == (newPosition)) {
					System.out.println("You have landed on " + squares[i].getSquareName() + " in "
							+ squares[i].getAreaField() + ".");
					player.setCurrentPosition(newPosition);

					// Action if landed on start square
					if (player.getCurrentPosition() == 0) {
						System.out.println("This is the Start square, you cannot purchase or develop on this.");

						// Action if landed on blank square
					} else if (player.getCurrentPosition() == 11) {
						System.out.println("This sqaure is blank");

						// Action if landed on square nobody owns
					} else if (squares[i].isOwned() == false) {
						System.out.println("This area available to purchase. It costs "
								+ squares[i].getBuyCost()
								+ " ECO Coins. Would you like to purchase control it? Please enter Y or N");
						String choice = null;
						do {
							try {
								choice = input.next();
								OK = true;
							} catch (Exception e) {
								System.out.println("Sorry, please enter Y or N.");
								OK = false;
								input.next();
							}
						} while (!OK);

						if (choice.equalsIgnoreCase("Y")) {
							if (checkResourcesToBuy(player, squares[i]) == false) {
								insufficientResources();

							} else {
								int previousBalance = player.getResourceBalance();
								String gameEndChoice = null;
								boolean validChoice = false;
								sufficientResources();

								// Check if developing will set player resource to 0
								if (previousBalance == squares[i].getBuyCost()) {

									do {
										System.out.println(
												"If you proceed with this dev, your ECO Coin balance will become 0 and the game will end."
														+ " Are you sure you want to continue? Please enter Y or N");

										gameEndChoice = input.next();

										if (gameEndChoice.equalsIgnoreCase("Y")
												|| gameEndChoice.equalsIgnoreCase("N")) {
											validChoice = true;
										} else {
											System.out.println("Invalid input.");
										}

									} while (!validChoice);

									// if you continue game will be finished
									if (gameEndChoice.equalsIgnoreCase("Y")) {
										quitGame = true;
									}

								}

								// Buy square
								if (gameEndChoice == null || gameEndChoice.equalsIgnoreCase("Y")) {
									buySquare(player, squares[i]);
									squares[i].setOwned(true);
									squares[i].setOwner(player.getName());
									purchasing();
									int newBalance = player.getResourceBalance();
									System.out.println("Your ECO Coin balance was: " + previousBalance + ".");
									System.out.println("You bought control of the " + squares[i].getSquareName()
											+ " area for " + squares[i].getBuyCost() + " ECO Coins.");
									System.out.println("Your new ECO Coin balance is: " + newBalance + ".");
									System.out.println("You now own the " + squares[i].getSquareName()
											+ " area within " + squares[i].getAreaField() + " energy field.");
									System.out.print("Please press enter to continue.....");
									input.nextLine();
									input.nextLine();
								}
							}

							// Offer square to other player if not wanting to purchase
						} else if (choice.equalsIgnoreCase("N")) {

							boolean offerOutFinished = false;
							do {
								System.out.println(
										"Would you like to offer this area to another player? Please enter Y or N");
								do {
									try {
										choice = input.next();
										OK = true;
									} catch (Exception e) {
										System.out.println("Sorry, please enter Y or N");
										OK = false;
										input.next();
									}
								} while (!OK);

								if (choice.equalsIgnoreCase("Y")) {

									boolean acceptedFinished = false;

									do {
										String otherPlayer = chooseOtherPlayer(player.getName(), players, input);
										System.out.println(otherPlayer
												+ ", do you accept this offer and want to purchase control of said area? Y or N");

										do {
											try {
												choice = input.next();
												OK = true;
											} catch (Exception e) {
												System.out.println("Sorry, please enter Y or N");
												OK = false;
												input.next();
											}
										} while (!OK);

										// If player wants to accept buying square
										if (choice.equalsIgnoreCase("Y")) {
											for (int j = 0; j < players.size(); j++) {
												if (otherPlayer.equals(players.get(j).getName())) {
													if (checkResourcesToBuy(players.get(j), squares[i]) == false) {
														insufficientResources();

													} else {
														int previousBalance = players.get(j).getResourceBalance();
														String gameEndChoice = null;
														boolean validChoice = false;
														sufficientResources();

														// Check if developing will set player resource to 0
														if (previousBalance == squares[i].getBuyCost()) {

															do {
																System.out.println(
																		"If you proceed with this dev, your ECO Coin balance will become 0 and the game will end."
																				+ " Are you sure you want to continue? Please enter Y or N");

																gameEndChoice = input.next();

																if (gameEndChoice.equalsIgnoreCase("Y")
																		|| gameEndChoice.equalsIgnoreCase("N")) {
																	validChoice = true;
																} else {
																	System.out.println("Invalid input.");
																}

															} while (!validChoice);

															// if you continue game will be finished
															if (gameEndChoice.equalsIgnoreCase("Y")) {
																quitGame = true;
															}

														}

														// Buy square
														if (gameEndChoice == null
																|| gameEndChoice.equalsIgnoreCase("Y")) {
															buySquare(players.get(j), squares[i]);
															squares[i].setOwned(true);
															squares[i].setOwner(players.get(j).getName());
															purchasing();
															int newBalance = players.get(j).getResourceBalance();
															System.out.println(players.get(j).getName()
																	+ " your ECO Coin balance was: " + previousBalance
																	+ ".");
															System.out.println("You bought control of the "
																	+ squares[i].getSquareName() + " area for "
																	+ squares[i].getBuyCost() + " ECO Coins.");
															System.out.println(
																	"Your new ECO Coin balance is: " + newBalance + ".");
															System.out.println("You now control the "
																	+ squares[i].getSquareName() + " area in the "
																	+ squares[i].getAreaField() + " energy field.");
															offerOutFinished = true;
															acceptedFinished = true;
															System.out
																	.print("Please press the enter key to continue.....");
															input.nextLine();
															input.nextLine();
														}

													}
												}
											}

											// If other player does not accept buying square
										} else if (choice.equalsIgnoreCase("N")) {
											System.out.println(otherPlayer + " has declined your offer.");
											acceptedFinished = true;

										} else {
											System.out.println("Unrecognised input....");
											acceptedFinished = false;
										}

									} while (!acceptedFinished);

									// if current player chooses not to offer square to another player
								} else if (choice.equalsIgnoreCase("N")) {
									System.out.println("You have chosen not to offer this area to another player.");
									offerOutFinished = true;
								}

							} while (!offerOutFinished);

						}

					} else {
						String choice = null;
						String owner = checkOwner(squares[i]);
						// Check if current player owns square
						if (player.getName() != owner) {
							System.out.println(
									"You have landed on an area that is controlled by another player. You must contribute "
											+ squares[i].getCurrentRent() + " ECO Coins towards their ECO fund.");
							// Check if owner of square wants to accept rent
							System.out.println(
									owner + ", do you wish to accept this funding contribution? Please enter Y or N");
							do {
								try {
									choice = input.next();

									if (choice.equalsIgnoreCase("Y")) {
										// Check if player has enough resources to pay rent
										if (checkResourcesForRent(player, squares[i]) == false) {
											quitGame = quitGame();
											break;
										} else {
											payRent(player, owner, squares[i], players);
											OK = true;
											System.out.print("Please press the enter key to continue..");
											input.nextLine();
											input.nextLine();
										}
									} else if (choice.equalsIgnoreCase("N")) {
										System.out.println(
												"You have declined the rent / funding amount for this area.");
										OK = true;

									} else {
										System.out.println(
												"Sorry. please type Y or N to confirm your choice.");
									}

								} catch (Exception e) {
									System.out.println("Please type Y or N to confirm your choice.");
									OK = false;
									input.next();
								}
							} while (!OK);

						} else {
							System.out.println("You already own this area.");
						}

					}
				}
			}

		} else {
			System.out.println("area not recognised.");
		}

		return quitGame;

	}

	/**
	 * Roll Dice
	 * @return int for rolling a dice between 1 and 6
	 */
	public static int rollDice() {
		int roll;
		Random rand = new Random();
		roll = (rand.nextInt(6) + 1);
		return roll;
	}

	/**
	 * Build a minor dev
	 * @param player
	 * @param squares
	 * @param input
	 */
	public static boolean buildMinorDev(Player player, Square[] squares, Scanner input) {

		String playerName = player.getName();
		String squareChoice = null;
		boolean OK = true;
		int count = 0;
		boolean messageDisplayed = false;
		int previousBalance = player.getResourceBalance();
		ArrayList<String> squareList = new ArrayList<String>();
		boolean isInSquareList = false;
		boolean quitGame = false;

		for (int i = 0; i < squares.length; i++) {
			if (squares[i].isOwned() && squares[i].getOwner().equals(playerName)) {

				// Check if player owns all areas in the field
				String currentAreaField = squares[i].getAreaField();
				boolean ownAllInAreaField = true;

				for (int j = 0; j < squares.length; j++) {
					if (squares[j].getAreaField().equals(currentAreaField)) {
						if (squares[j].getOwner() == null) {
							ownAllInAreaField = false;
						} else {
							if (squares[j].getOwner().equals(playerName)) {
								// Don't change ownAllInAreaField
							} else {
								ownAllInAreaField = false;
							}
						}
					}
				}

				// If player owns all areas in a energy field then display areas
				if ((ownAllInAreaField == true) && (squares[i].getDevCount() < 3)) {

					if ((messageDisplayed == false) && (squares[i].getDevCount() < 3)) {
						System.out.println("The area(s) belonging to " + playerName + " that can be developed further are: ");
						messageDisplayed = true;
					}
					count++;
					System.out.println("* "+squares[i].getSquareName() + " - " + squares[i].getMinDevCost() + " ECO Coins");

					// Add to squareList
					squareList.add(squares[i].getSquareName());
				}
			}
		}

		if (count <= 0) {
			OK = false;
		}

		while (OK) {
			System.out.println("Please select the area you wish to develop:");
			do {
				try {
					squareChoice = input.next();
					// Check that input was in list of squares offered to dev
					for (int i = 0; i < squareList.size(); i++) {
						if (squareChoice.equals(squareList.get(i))) {
							isInSquareList = true;
						}
					}

					if (isInSquareList == true) {
						OK = true;
					} else {
						System.out.println(
								"Sorry, please select one from the option(s) available.");
						OK = false;
					}
				} catch (Exception e) {
					System.out.println("Please select from the available option(s).");
					OK = false;
					input.next();
				}
			} while (!OK);

			for (int i = 0; i < squares.length; i++) {
				if (squares[i].getSquareName().equalsIgnoreCase(squareChoice)) {
					if (squares[i].getDevCount() < 3) {
						if (checkResourcesToBuyMinDev(player, squares[i]) == false) {
							insufficientResources();
						} else {
							String gameEndChoice = null;
							boolean validChoice = false;
							sufficientResources();

							// Check if developing will set player resource to 0
							if (previousBalance == squares[i].getMinDevCost()) {

								do {
									System.out.println(
											"If you proceed with this dev, your ECO Coin balance will become 0 and the game will end."
													+ " Are you sure you want to continue? Please enter Y or N");

									gameEndChoice = input.next();

									if (gameEndChoice.equalsIgnoreCase("Y") || gameEndChoice.equalsIgnoreCase("N")) {
										validChoice = true;
									} else {
										System.out.println("Input not recognised.");
									}

								} while (!validChoice);

								// if you continue game will be finished
								if (gameEndChoice.equalsIgnoreCase("Y")) {
									quitGame = true;
								}

							}

							// Build dev
							if (gameEndChoice == null || gameEndChoice.equalsIgnoreCase("Y")) {

								buyMinDev(player, squares[i]);
								purchasing();
								System.out.println(squares[i].getSquareName() + " now has " + squares[i].getDevCount()
										+ " dev stage(s) complete, total cost: " + squares[i].getMinDevCost()
										+ " ECO Coins. The funding contribution for this area is now "
										+ squares[i].getCurrentRent() + " ECO Coins.");
								System.out.println("Your balance before development was " + previousBalance
										+ " ECO Coin. Your new balance is " + player.getResourceBalance() + " ECO Coins.");
								System.out.print("Please press the enter key to continue.....");
								input.nextLine();
								input.nextLine();
							}
						}

					} else {
						System.out.println("This area is fully developed.");
						System.out.println();
						System.out.print("Please press enter to continue.....");
						input.nextLine();
						input.nextLine();
					}
				}
			}

			break;
		}

		if (!OK) {
			System.out.println("You do not own any areas that qualify for development.");
			System.out.print("Please press the enter key to continue.....");
			input.nextLine();
			input.nextLine();
		}

		return quitGame;

	}

	/**
	 * Build a major dev
	 * 
	 * @param player
	 * @param squares
	 * @param input
	 */
	public static boolean buildMajorDev(Player player, Square[] squares, Scanner input) {

		String playerName = player.getName();
		String squareChoice = null;
		boolean OK = true;
		int count = 0;
		boolean messageDisplayed = false;
		int previousBalance = player.getResourceBalance();
		ArrayList<String> squareList = new ArrayList<String>();
		boolean isInSquareList = false;
		boolean quitGame = false;

		// List squares owned by the player which have 3 devs already in place
		for (int i = 0; i < squares.length; i++) {
			if (squares[i].isOwned() && squares[i].getOwner().equals(playerName) && squares[i].getDevCount() == 3
					&& squares[i].isMajorDev() == false) {
				count++;

				if (messageDisplayed == false) {
					System.out.println("The area(s) " + playerName + " can develop to help complete an Energy Field are: ");
					messageDisplayed = true;
				}

				// output name of square
				System.out.println(squares[i].getSquareName() + " - " + squares[i].getMajorDevCost() + " ECO Coins");

				// Add square to list
				squareList.add(squares[i].getSquareName());
			}
		}

		if (count <= 0) {
			OK = false;
		}

		while (OK) {
			System.out.println("Please select the area you wish to develop:");
			do {
				try {
					squareChoice = input.next();
					// Check user input is available
					for (int i = 0; i < squareList.size(); i++) {
						if (squareChoice.equals(squareList.get(i))) {
							isInSquareList = true;
						}
					}

					if (isInSquareList == true) {
						OK = true;
					} else {
						System.out.println(
								"Sorry, please select one from the option(s) available.");
						OK = false;
					}

				} catch (Exception e) {
					System.out.println("Please select from the available option(s).");
					OK = false;
					input.next();
				}
			} while (!OK);

			for (int i = 0; i < squares.length; i++) {
				if (squares[i].getSquareName().equalsIgnoreCase(squareChoice)) {
					if (checkResourcesToBuyMajDev(player, squares[i]) == false) {
						insufficientResources();
					} else {
						String gameEndChoice = null;
						boolean validChoice = false;
						sufficientResources();

						// Check if developing will set player resource to 0
						if (previousBalance == squares[i].getMajorDevCost()) {

							do {
								System.out.println(
										"If you proceed with this dev, your ECO Coin balance will become 0 and the game will end."
												+ " Are you sure you want to continue? Please enter Y or N");

								gameEndChoice = input.next();

								if (gameEndChoice.equalsIgnoreCase("Y") || gameEndChoice.equalsIgnoreCase("N")) {
									validChoice = true;
								} else {
									System.out.println("Unrecognised input....");
								}

							} while (!validChoice);

							// if you continue game will be finished
							if (gameEndChoice.equalsIgnoreCase("Y")) {
								quitGame = true;
							}

						}

						// Build dev
						if (gameEndChoice == null || gameEndChoice.equalsIgnoreCase("Y")) {
							buyMajDev(player, squares[i]);
							purchasing();
							System.out.println(squares[i].getSquareName() + " has now been built at a cost of "
									+ squares[i].getMajorDevCost()
									+ " ECO Coins. The funding contribution for this area is now "
									+ squares[i].getCurrentRent() + " ECO Coins.");
							System.out.println("Your balance before building was " + previousBalance
									+ " ECO Coin, your new balance is " + player.getResourceBalance() + " ECO Coins.");
							System.out.print("Please press the enter key to continue.....");
							input.nextLine();
							input.nextLine();
						}

					}

				}
			}

			break;
		}

		if (!OK) {
			System.out.println(
					"Unfortunately, you do not own all areas to complete an energy field");
			System.out.print("Please press the enter key to continue.....");
			input.nextLine();
			input.nextLine();
		}

		return quitGame;

	}

	
	/**
	 * Current players and balances
	 * 
	 * @param players
	 */
	public static void viewPlayerStatus(ArrayList<Player> players) {
		System.out.printf("%-20s %-15s %n", "Player Name", "ECO Coins Remaining");
		System.out.println("--------------------------------------------------");
		for (Player p : players) {
			System.out.printf("%-20s %-15s %n", p.getName(), p.getResourceBalance());
		}
	}

	
	/**
	 * This displays the status of every square .... who owns it, the dev count (minor and major) 
	 * and the current rent values alongside rent / contributions paid by other players )
	 * 
	 * @param squares
	 */
	public static void viewBoardStatus(Square[] squares) {
		System.out.printf("%-25s %-15s %-12s %-25s %-20s %-15s %n", "Area Name", "Is Owned", "Owned By",
				"Dev Stage (0 to 3)", "Field Complete", "Rent / Funding Contribution");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
		for (Square s : squares) {
			System.out.printf("%-26s %-16s %-18s %-21s %-26s %-15s %n", s.getSquareName(), s.isOwned(), s.getOwner(),
					s.getDevCount(), s.isMajorDev(), s.getCurrentRent());

		}
	}
	

	/**
	 * Display game options list for playing
	 */
	public static void displayOptions() {
		System.out.println("Please select your action from the list below:");
		System.out.println("1. Roll your dice");
		System.out.println("2. Develop a minor dev on an area");
		System.out.println("3. Complete build on an area to help complete an Energy Field");
		System.out.println("4. Skip your turn entirely or move to next player after rolling");
		System.out.println("5. View the current player(s) status");
		System.out.println("6. View the current board status");
		System.out.println("7. Quit game");
		System.out.println("Please select your option by pressing the relevant number");
	}

	
	/**
	 * Purchase a square: also known as an area
	 * 
	 * @param player
	 * @param square
	 */
	public static void buySquare(Player player, Square square) {

		int resourcesRemaining = player.getResourceBalance();
		int costOfSquare = square.getBuyCost();

		int newBalance = resourcesRemaining - costOfSquare;

		player.setResourceBalance(newBalance);

		// rent for square changes from 0 to rentNoDev
		int newRent = square.getRentNoDev();
		square.setCurrentRent(newRent);
	}

	
	/**
	 * Pay rent / contribution when landing on an area someone else owns
	 * 
	 * @param player
	 * @param owner
	 * @param square
	 * @param players
	 */
	public static void payRent(Player player, String owner, Square square, ArrayList<Player> players) {
		int resourcesRemaining = player.getResourceBalance();
		int currentRent = square.getCurrentRent();

		// subtract rent paid off player's current balance
		int newBalance = resourcesRemaining - currentRent;
		player.setResourceBalance(newBalance);

		// get owners current balance
		int ownerCurrentBalance = 0;
		for (int i = 0; i < players.size(); i++) {
			if (owner.equals(players.get(i).getName())) {
				ownerCurrentBalance = players.get(i).getResourceBalance();
			}
		}

		// rent / contribution gets added to owner's balance
		int ownerNewBalance = ownerCurrentBalance + currentRent;

		for (int i = 0; i < players.size(); i++) {
			if (owner.equals(players.get(i).getName())) {
				players.get(i).setResourceBalance(ownerNewBalance);
			}
		}

		System.out.println("You have contributed " + currentRent + " ECO Coins for landing on " + owner
				+ "'s area. Your remaining ECO Coin balance is " + newBalance + ".");
		System.out.println(owner + ", your updated ECO Coin balance is " + ownerNewBalance + ".");
	}

	
	/**
	 * Check that a player has enough resources to buy an area
	 * 
	 * @param player
	 * @param square
	 * @return true if they do, false if they don't
	 */
	public static boolean checkResourcesToBuy(Player player, Square square) {
		boolean resourcesAvailable = false;
		int resourcesRemaining = player.getResourceBalance();
		int costOfSquare = square.getBuyCost();

		if (resourcesRemaining >= costOfSquare) {
			resourcesAvailable = true;
		} else {
			resourcesAvailable = false;
		}

		return resourcesAvailable;
	}

	
	/**
	 * Check a player has enough resources to pay rent / contribute
	 * 
	 * @param player
	 * @param square
	 * @return true if they do, false if they don't
	 */
	public static boolean checkResourcesForRent(Player player, Square square) {
		boolean resourcesAvailable = false;
		int resourcesRemaining = player.getResourceBalance();
		int currentRent = square.getCurrentRent();

		if (resourcesRemaining > currentRent) {
			resourcesAvailable = true;
		} else {
			resourcesAvailable = false;
		}

		return resourcesAvailable;
	}
	

	/**
	 * Buy a minor dev for an area that is owned
	 * 
	 * @param player
	 * @param square
	 */
	public static void buyMinDev(Player player, Square square) {
		int resourcesRemaining = player.getResourceBalance();
		int minDevCost = square.getMinDevCost();
		int devCount = square.getDevCount();

		// Adjust player balance
		int newBalance = resourcesRemaining - minDevCost;
		player.setResourceBalance(newBalance);

		// Adjust dev count
		int newDevCount = devCount + 1;
		square.setDevCount(newDevCount);

		// Update current rent
		switch (newDevCount) {
		case 1:
			square.setCurrentRent(square.getRentOneDev());
			break;
		case 2:
			square.setCurrentRent(square.getRentTwoDev());
			break;
		case 3:
			square.setCurrentRent(square.getRentThreeDev());
			break;
		}

	}

	
	/**
	 * Buy a major dev for an area
	 * 
	 * @param player
	 * @param square
	 */
	public static void buyMajDev(Player player, Square square) {
		int resourcesRemaining = player.getResourceBalance();
		int majDevCost = square.getMajorDevCost();
		int newBalance = resourcesRemaining - majDevCost;
		player.setResourceBalance(newBalance);

		square.setMajorDev(true);
		square.setCurrentRent(square.getRentMajorDev());
	}

	
	/**
	 * Check if relevant player has enough resources to buy a minor dev
	 * 
	 * @param player
	 * @param square
	 * @return true if they do, false if they don't
	 */
	public static boolean checkResourcesToBuyMinDev(Player player, Square square) {
		boolean resourcesAvailable = false;
		int resourcesRemaining = player.getResourceBalance();
		int minDev = square.getMinDevCost();

		if (resourcesRemaining >= minDev) {
			resourcesAvailable = true;
		} else {
			resourcesAvailable = false;
		}

		return resourcesAvailable;
	}

	
	/**
	 * Check if have enough resources to buy a major dev
	 * 
	 * @param player
	 * @param square
	 * @return true if they do, false if they don't
	 */
	public static boolean checkResourcesToBuyMajDev(Player player, Square square) {
		boolean resourcesAvailable = false;
		int resourcesRemaining = player.getResourceBalance();
		int majDevCost = square.getMajorDevCost();

		if (resourcesRemaining >= majDevCost) {
			resourcesAvailable = true;
		} else {
			resourcesAvailable = false;
		}

		return resourcesAvailable;
	}

	
	/**
	 * Pick new player to offer your square
	 * 
	 * @param currentPlayer
	 * @param players
	 * @param input
	 * @return other player that square has been offered out to
	 */
	public static String chooseOtherPlayer(String currentPlayer, ArrayList<Player> players, Scanner input) {

		String otherPlayer = null;
		boolean OK = false;
		String choice = null;
		ArrayList<String> offerList = new ArrayList<String>();
		boolean isInOfferList = false;
		System.out.println("What other player would you like to offer the area to?");

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(currentPlayer)) {
			} else {
				System.out.println(players.get(i).getName());
				offerList.add(players.get(i).getName());
			}
		}

		do {
			try {
				choice = input.next();

				// Check the chosen player is current and spelt correct
				for (int i = 0; i < offerList.size(); i++) {
					if (choice.equals(offerList.get(i))) {
						isInOfferList = true;
					}
				}

				if (isInOfferList == true) {
					OK = true;
				} else {
					System.out
							.println("Sorry, you must choose a player from the list of active players available above");
					OK = false;
				}

			} catch (Exception e) {
				System.out.println("Please choose a player, and enter his name (a-z / A-Z)");
				OK = false;
				input.next();
			}
		} while (!OK);

		System.out.println("You have offered " + choice + " to control the area.");
		otherPlayer = choice;

		return otherPlayer;
	}

	
	/**
	 * Check who owns a square
	 * 
	 * @param square
	 * @return player name of who owns the square
	 */
	public static String checkOwner(Square square) {
		String owner = square.getOwner();
		System.out.println("This area is currently owned by " + owner + ".");
		return owner;
	}

	
	/**
	 * Quit the game
	 * 
	 * @return quitGame = true
	 */
	public static boolean quitGame() {
		boolean quitGame = true;

		return quitGame;
	}

	
	/**
	 * Display insufficient resources message
	 */
	public static void insufficientResources() {
		try {
			System.out.println("Checking ECO Coin balance.....");
			Thread.sleep(dramaticPause);
			System.out.println("Your funds are too low.");
		} catch (InterruptedException e) {
			System.out.println("Interruption: insufficentResources method.");
			System.out.flush();
		}
	}

	
	/**
	 * Display sufficient resources message
	 */
	public static void sufficientResources() {
		try {
			System.out.println("Checking ECO Coin balance.....");
			Thread.sleep(dramaticPause);
			System.out.println("You have sufficient funds for purchase.");
		} catch (InterruptedException e) {
			System.out.println("Interruption: sufficentResources method.");
			System.out.flush();
		}
	}

	
	/**
	 * Display message for purchasing an area
	 */
	public static void purchasing() {
		try {
			System.out.println("Beginning transaction.....");
			Thread.sleep(dramaticPause);
			System.out.println("---------------------------");		
			System.out.println("Transaction completed.");
			System.out.println("---------------------------");		
		} catch (InterruptedException e) {
			System.out.println("Interruption: purchasing method.");
			System.out.flush();
		}
	}

	
	/**
	 * Check if major devs (builds) have been made on all areas
	 * 
	 * @param squares
	 * @return true if they do, false if they don't
	 */
	public static boolean boardComplete(Square[] squares) {
		boolean complete = false;
		int count = 0;
		int fullMajorDevCount = 10;

		for (int i = 0; i < squares.length; i++) {
			if (squares[i].isMajorDev() == true) {
				count++;
			}
		}

		if (count == fullMajorDevCount) {
			complete = true;
			return complete;
		} else {
			complete = false;
			return complete;
		}
	}

	
	/**
	 * successful completion method
	 * 
	 * @param players
	 */
	public static void successfulEcoMission(ArrayList<Player> players) {
		System.out.println("Congratulations..... you have saved the Planet!");
		try {
			Thread.sleep(1000);
			System.out.println("The world owes you a great deal");
			Thread.sleep(1000);
			System.out.println("Congratulations to those below, you're all heroes: ");
			for (Player p : players) {
				System.out.println(p.getName());
			}
			System.out.println("Without your help, dedication and sacrifice, this would not have been possible!");
		} catch (InterruptedException e) {
			System.out.println("Interruption catch: successfulEcoMission method");
			System.out.flush();
		}
	}

	
	/**
	 * unsuccessful completion method
	 * 
	 * @param players
	 */
	public static void failedEcoMission(Board board, ArrayList<Player> players) {
		try {
			System.out.println("You failed to develop enough Eco resources to Save Our Planet!");
			Thread.sleep(1000);
			System.out.println("We are all doomed! %n");
			Thread.sleep(1000);
			System.out.println("Please find a game summary, and player stats, below");
			viewPlayerStatus(players);
			System.out.println();
			viewBoardStatus(board.getBoard());
		} catch (InterruptedException e) {
			System.out.println("Interruption catch: failedEcoMission method");
			System.out.flush();
		}
		System.out.println();
		System.out.println("Game Over, goodbye and good luck!");
	}

} // end of class