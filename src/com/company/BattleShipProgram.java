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
            System.out.println("Choose 2: Player vs Computer [Easy]");
            System.out.println("Choose 3: Player vs Computer [Medium]");
            System.out.println("Choose 0: To exit");
            int choices = input.nextInt();
            switch (choices) {
                case 1:
                    System.out.println("Good you choose to play with another Player");
                    players = new Player[2];
                    players.add(new Human("Player1", new BoardGame(10, 10)));
                    players.add(new Human("Player2", new BoardGame(10, 10)));
                    break;
                case 2:
                    System.out.println("Player vs Computer [Easy]");
                    players = new Player[2];
                    players.add(new Human("Player1", new BoardGame(10, 10)));
                    players.add(new Computer("Player2", new BoardGame(10, 10)));
                    break;
                case 3:
                    System.out.println("Player vs Computer [Medium]");
                    players = new Player[2];
                    players.add(new Human("Player1", new BoardGame(10, 10)));
                    players.add(new Computer("Player2", new BoardGame(10, 10)));
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
    //every player must place their ships, includes every player
    // void = doesn`t return
    private void Play() {
        for (Player player : players) {
            player.placeShips();
        }

        while (true) {
            for (Player player : players) {
                int oponent = player.selectOponentPlayer();
                players[oponent].displayMap();
                Position position = player.shoot();
                players[oponent].shotAtPosition(position);

            }
        }
    }
}
