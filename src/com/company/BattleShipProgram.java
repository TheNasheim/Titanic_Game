package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleShipProgram {

    private Scanner input = new Scanner(System.in);
    private boolean quit = true;
    private Player[] players;


    public BattleShipProgram() {
        mainMenuSelection();
    }

    public void mainMenuSelection() {

        do {
            System.out.println("Choose Opponent");
            System.out.println("Choose 1: Player vs Player");
            System.out.println("Choose 2: Player vs Computer [Dumb]");
            System.out.println("Choose 3: Player vs Computer [Medium]");
            System.out.println("Choose 0: To exit");
            int choices = input.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("Good you choose to play with another Player");
                    players = new Player[2];
                    players[0] = new Human("Player 1", 0, new BoardGame(10, 10));
                    players[1] = new Human("Player 2", 1, new BoardGame(10, 10));
                    playGame();
                    break;
                case 2:
                    System.out.println("Player vs Computer [Dumb]");
                    players = new Player[2];
                    players[0] = new Human("Player 1", 0, new BoardGame(10, 10));
                    players[1] = new Computer("Mr.Potato", 1, new BoardGame(10, 10));
                    playGame();
                    break;
                case 3:
                    System.out.println("Player vs Computer [Medium]");
                    players = new Player[2];
                    players[0] = new Human("Player 1", 0, new BoardGame(10, 10));
                    players[1] = new Computer("H.A.L", 1, new BoardGame(10, 10));
                    playGame();
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

    // a method with Play
    // void = doesn`t return
    // every player must place their ships, includes every player
    // gameRunning is for the while loop, while it`s gameRunning is true
    // For every player shoose oponent player
    // Oponent player displayMap
    // Player returns shooting position
    // Oponent returns their hit or miss from the oponent player
    // If the ship got hit check
    // If the oponent have no ships left, the other player won

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
                        opponent = players[currentPlayerIndex].selectOponentPlayer();
                    }
                    players[opponent].displayMap();
                    while(hit == SquareState.NONE) {
                        Position position = players[currentPlayerIndex].shoot();
                        hit = players[opponent].shotAtPosition(position);
                    }
                } else {
                    opponent = players[currentPlayerIndex].selectOponentPlayer();
                    players[opponent].displayMap();
                    Position position = players[currentPlayerIndex].shoot();
                    hit = players[opponent].shotAtPosition(position);
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
