package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleShipProgram {

    private Scanner input = new Scanner(System.in);
    private boolean quit = true;
    private Player[] players;
    private Position mapSize = new Position(10, 10);


    public BattleShipProgram() {
        mainMenuSelection();
    }

    //Here is a method, MenuSetup
    //You can choose menu selections, size of map or how many ships you would like to have
    //Used Scanner to read the text in
    //while do loop
    //switch menu
    public void MenuSetup() {
        do {
            System.out.println("Setup menu");
            System.out.println("Choose 1: Size of map");
            System.out.println("Choose 0: Exit to main menu");
            System.out.println("Enter choice");
            //System.out.println("Choose 2: How many ships");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    int x;
                    int y;
                    while(true) {
                        System.out.println("Write x");
                        x = input.nextInt();
                        System.out.println("Write y");
                        y = input.nextInt();
                        if (x < 5 || y < 5 || x > 25 || y > 25) {
                            System.out.println("---ERROR---\nMust be between 5 and 25");
                            continue;
                        }
                        break;
                    }
                    mapSize = new Position(x, y);
                    quit = false;
                    break;
                case 0:
                    quit = false;
                    break;
                default:
            }
        }while(quit);
    }

    public void mainMenuSelection() {

        do {
            //System.out.println("Battleship");
            System.out.println("Choose Opponent");
            System.out.println("Choose 1: Player vs Player");
            System.out.println("Choose 2: Player vs Computer [Dumb]");
            System.out.println("Choose 3: Player vs Computer [Medium]");
            System.out.println("Choose 4: Enter Setup Menu");
            System.out.println("Choose 0: To exit");
            int choices = input.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("Good you choose to play with another Player");
                    players = new Player[2];
                    players[0] = new Human("Player 1", 0, new BoardGame(mapSize.getX(),mapSize.getY()));
                    players[1] = new Human("Player 2", 1, new BoardGame(mapSize.getX(),mapSize.getY()));
                    playGame();
                    break;
                case 2:
                    System.out.println("Player vs Computer [Dumb]");
                    players = new Player[2];
                    players[0] = new Human("Player 1", 0, new BoardGame(mapSize.getX(),mapSize.getY()));
                    players[1] = new Computer("Mr.Potato", 1, new BoardGame(mapSize.getX(),mapSize.getY()));
                    playGame();
                    break;
                case 3:
                    System.out.println("Player vs Computer [Medium]");
                    players = new Player[2];
                    players[0] = new Human("Player 1", 0, new BoardGame(mapSize.getX(),mapSize.getY()));
                    players[1] = new Computer("H.A.L", 1, new BoardGame(mapSize.getX(),mapSize.getY()));
                    playGame();
                    break;
                case 4:
                    MenuSetup();
                    quit=true;
                    break;
                case 0:
                    quit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (quit);
        System.out.println("Bye-bye");
    }


    // playGame() is the start of the vs game were you start at placing your ships.
    // and after that first player starts to shoot at the opponent players map.
    // This will stop its loop when one player has 0 ships left.

    // 1. First for loop is for every player in players array.
    // In loop first is a text to tell player who's turn it is to place out the ships on the map.
    // 1.2. The while loop will run until somewhere tells it to return from the loop
    // 1.3. Inside the loop there is a for loop for every player
    // Squarestate hit is set to NONE from a Enum and opponent is set to 0;
    // 1.4. prints out who's turn it is to shoot
    // 1.5 if there is 2 players
    // 1.5.2 and if the player is a Human Class.
    // 1.5.2 then checks what the current player array nr is and sets to opposite 1 > 0 or 0 > 1.
    // 1.5.4 else if it is not a Human Class then start function selectOponentPlayer(). It is so computer can also select its own map by mistake.
    // 1.6. The player will be shown the opponents Map
    // 1.7. A while loop will check if hit has SquareState.NONE
    // 1.7.1 returns Position from what X&Y player want to shoot at.
    // 1.7.2 returns a SquareState if it was a hit or miss. If it returns a NONE there must have been something wrong and goes back to (1.7.)
    // 1.8 If it is more then 2 palyers.
    // 1.8.1 start function selectOponentPlayer() so player can select who player want's to hit
    // 1.8.2 same as 1.6, 1.7
    // 1.9 If hit is a HIT then
    // 1.9.1 print out that it was a hit
    // 1.9.2 now it will check how many ships the apponent has left
    // 1.9.2.1 If opponent has 0 ships left
    // 1.9.2.2 print out that player has won.
    // 1.9.2.3 now return from the playGame() while loop
    // 1.9.3 if it was a miss
    // 1.9.3.1 print out that it was a miss
    // 1.10 print out press enter to continue
    // 1.11 waits for press enter input.
    // 1.12 return to (1.4) and back we gooo...
    private void playGame() {

        for (Player player : players) {
            System.out.println("It is " + player.getName() + " turn to place the ships.");
            player.placeShips();
        }

        while (true) {
            for (int currentPlayerIndex = 0; currentPlayerIndex < players.length; currentPlayerIndex++) {
                SquareState hit = SquareState.NONE;
                int opponent = 0;
                System.out.println("It is " + players[currentPlayerIndex].getName() + " turn to Shoot.");
                if (players.length == 2) {
                    if (players[currentPlayerIndex] instanceof Human) {
                        opponent = (currentPlayerIndex == 0) ? 1 : 0;
                    } else {
                        opponent = players[currentPlayerIndex].selectOpponentPlayer();
                    }
                    players[opponent].displayMap();
                    while(hit == SquareState.NONE) {
                        Position position = players[currentPlayerIndex].shoot();
                        hit = players[opponent].shotAtPosition(position);
                    }
                } else {
                    opponent = players[currentPlayerIndex].selectOpponentPlayer();
                    players[opponent].displayMap();
                    while(hit == SquareState.NONE) {
                        Position position = players[currentPlayerIndex].shoot();
                        hit = players[opponent].shotAtPosition(position);
                    }
                }
                if (hit == SquareState.HIT) {
                    System.out.println("That was a HIT!");
                    int shipsLeft = players[opponent].getShipsLeft();
                    if (shipsLeft == 0) {
                        System.out.println("YOU WON!");
                        return;
                    }
                }
                else {
                    System.out.println("That was a miss.");
                }
                System.out.println("Press Enter to continue.");
                    input.nextLine();
            }
        }
    }
}
