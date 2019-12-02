package com.company;

import java.util.Scanner;

public class BattleShipProgram {

    private boolean menuSelection = true;
    private Scanner input = new Scanner(System.in);
    private boolean quit = true;


    public BattleShipProgram(){

    }

    public void mainMenuSelection(int choices){

        do {
            System.out.println("Choose Opponent");
            System.out.println("Choose 1: Player vs Player");
            System.out.println("Choose 2: Player vs Computer [Easy]");
            System.out.println("Choose 3: Player vs Computer [Medium]");
            System.out.println("Choose 0: To exit");
            choices = input.nextInt();
            switch(choices) {
                case 1:
                    System.out.println("Good you choose to play with another Player");
                    break;
                case 2:
                    System.out.println("Player vs Computer [Easy]");
                    break;
                case 3:
                    System.out.println("Player vs Computer [Medium]");
                    break;
                case 0:
                    quit = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(quit);
        System.out.println("Bye-bye");
    }
}
