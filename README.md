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








