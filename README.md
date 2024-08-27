# SaveOurPlanet BoardGame

Game Introduction, Overview and Rules.
Introduction
Save our planet is a Java based board game for 1-4 players where each player is out to build a better,
greener future for future generations. Players must use ECO Coins to purchase and develop areas
around the game board. The game board is made up of 12 tiles which are divided into fields which
are then further divided into areas. The fields and areas included in the game are as follows in the
game board image

![image](https://github.com/user-attachments/assets/2a025a5a-9405-4fe7-a73f-fa8db8ef82cf)

Game Introduction, Overview and Rules.
Introduction
Save our planet is a Java based board game for 1-4 players where each player is out to build a better,
greener future for future generations. Players must use ECO Coins to purchase and develop areas
around the game board. The game board is made up of 12 tiles which are divided into fields which
are then further divided into areas. The fields and areas included in the game are as follows in the
game board image:
Rules
To control the flow of the game, rules have been agreed upon based on our use case scenarios and
have been implemented in the code and will be displayed throughout the overview.
1. There can be between 1-4 players.
2. Each player will start the game with 1000 ECO Coins
3. Players must choose a name with a length of at least one character.
4. Players cannot use the same name.
5. Players must own all areas within a field before developments can be built.
a. Players must build 3 Minor Developments in an area before they can build a Major
Development
6. If a player lands on a tile owned by another player, they must pay rent to the owner.
a. The owner of the tile has the option to decline the payment.
7. If a player lands on an unowned tile and does not wish to purchase it, they may offer it to
other players.
8. When each player passes ECO Base Start, they will receive 200 ECO Coins.
9. When any players ECO Coin balance reaches zero, the game is over.
Figure 1: Game Board
10. If any player choses to quit the game, the game ends for all players.


Overview
To begin the game, the users must first decide how many players there will be, between a minimum
of 1 and a maximum of 4, if a number outside of this range is entered, or any other character is
entered, the users will be prompted to enter a number between 1-4.

![image](https://github.com/user-attachments/assets/912344e2-5f59-4ed3-85c6-e87f66dc3de6)

Players must then enter their chosen names. The name of the player must be at least one character
long and may only contain letters a-z / A-Z, the name must be unique. If the user choses to enter a
name of length 0 or use numbers, they will be prompted to try again with letters.

![image](https://github.com/user-attachments/assets/d94ae7b5-dd34-4528-a981-4cb28dad1fc5)

When players land on an unowned tile, they have the option to purchase that tile at a cost to their
ECO Coins. Purchasing an area updates the owner variable attached to the square with the players
name. This will allow the player to receive rent payments from other players who subsequently land
on that tile. To maximise the rental income from each of their tiles, players should aim to build
developments on each tile that they own.

![image](https://github.com/user-attachments/assets/491b8a4d-b077-4fdd-a3cd-e3ed1395f336)

If the player chooses not to buy the area, they can offer the area to another player for the same
cost. They simply must enter the desired players name to offer the area to and the desired player
must say yes or no. If the player does not wish to purchase, the original player may offer to another
player. Allowing another player to purchase the area utilises the same method as purchasing during
the original players turn.

![image](https://github.com/user-attachments/assets/b0cb23ba-1635-48a7-93cc-c90d3bebb075)

If the player lands on an area owned by another player, they must make an offer to pay rent to the
owner of the area. The owner may decline to accept the payment

![image](https://github.com/user-attachments/assets/a6cb2467-9a65-4c63-8a77-23abca98877a)

Developments improve the quality of the area and come in two distinct types: Minor and Major
Developments. Each area can hold 3 Minor Developments and one Major Development.
Minor Developments provide small boosts to the rental income for each area, but that is
incremented with each build. Major Developments provide a large boost to rental income. The ECO
coin cost of each of the Major & Minor Developments is reflective of how eco-friendly the field in
question is. For example, fossil fuels have the lowest upfront cost for an energy source but have a
low return value when compared to Renewable energies which cost more up front but have the
largest returns in the game.
A list of all Up-Front, Development & rental costs can be found below:

![image](https://github.com/user-attachments/assets/51872b90-2f47-467b-8a50-52486c891f2e)

To unlock the ability to build Minor Developments within an area, the player must first own all areas
within a given field. After building 3 Minor Developments on an area, the player then unlocks the
ability to build one Major Development to finish off the area. If any player attempts to build a
development before they have met the criteria, a message will be displayed to advise them.

![image](https://github.com/user-attachments/assets/65397547-e7fa-40a4-8e95-a98c601e7cff)

During each turn the player can choose which actions they would like to take. Each player can roll
the dice to move around the board or choose to build the available developments for their areas.
They can also review the status of all players and squares on the game board. While there is no limit
to the number of actions a player can take on any given turn, they may only develop as far as their
ECO coin balance will allow them.
If one player runs out of ECO Coins, or all areas on the game board have a Major Development, the
game will end in failure or success respectively for all players. The game continually checks players
ECO Coin balance and checks if all sites have a major development at the start of each round.
We have built Save Our Planet primarily with the customers required specifications in mind, but we
have also focussed on expandability. While the maximum number of players is defined above as 4,
the process of changing the maximum number of players is as simple as changing the value of a Final
Static Int in the MainGame file named maxPlayers. All data structures that manage the current
player base are ArrayLists and as such, can be as big or as small as the customer would like. Likewise
for the size of the game board. This is defined in the MainGame file as a final static int named
maxBoardSize which is defaulted to 12. If the customer so wishes, they can update the source code
to allow as many or as little squares to be created for each game. This is based on a local CSV file
which contains Field Names and area names. If the max number of squares on the game board is set
to a number larger than the number of defined Field & Area names in the CSV, they will be recycled,
and each new iteration of a field and area will display a numerical order. While both features have
not been requested in the Project Specification, they each display that we have created the project
with future adaptions in mind.







