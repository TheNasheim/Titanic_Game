package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player {

    public Human(String name, BoardGame map) {
        super(name, map);
    }

    private Position[] getCoordinates(int shipSize) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        boolean horizontal;

        // horizontal or vertical
        while(true) {
            System.out.print("Horizontal or vertical: ");
            String alignment = scanner.nextLine().toLowerCase();

            if(alignment.equals("vertical")) {
                horizontal = false;
            }
            else if(alignment.equals("horizontal")) {
                horizontal = true;
            }
            else {
                System.out.println("ERROR: You have to enter \"horizontal\" or \"vertical\". Try again!");
                continue;
            }

            break;
        }

        // x-coordinate
        while(true) {
            try {
                System.out.print("Enter " + (horizontal ? "leftmost" : "topmost") + " x-coordinate: ");
                x = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("ERROR: You have to enter a number! Try again!");
                continue;
            }
            break;
        }

        // y-coordinate
        while(true) {
            try {
                System.out.print("Enter " + (horizontal ? "leftmost" : "topmost") + " y-coordinate: ");
                y = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("ERROR: You have to enter a number! Try again!");
                continue;
            }
            break;
        }

        x--; // make 1-based index into 0-based
        y--; // make 1-based index into 0-based

        Position[] positions = new Position[shipSize];

        for (int i = 0; i < shipSize; i++) {
            if(horizontal) {
                positions[i] = new Position(x + i, y);
            }
            else { // vertical
                positions[i] = new Position(x, y + i);
            }
        }

        // DEBUG
        for (Position position : positions) {
            System.out.println("X:" + position.getX() + " Y:" + position.getY());
        }

        return positions;
    }

    @Override
    public void placeShips() {
        // place submarine
        do {
            System.out.println("Place submarine...");
            Submarine submarine = new Submarine(new ArrayList<Position>(Arrays.asList(getCoordinates(3))));
            getMap().addShip(submarine);
            break;
        } while(true);


        /*
        // destroyer
        System.out.println("Place destroyer...");
        Destroyer destroyer = new Destroyer(new ArrayList<Position>(Arrays.asList(getCoordinates(2))));

        // cruiser
        System.out.println("Place cruiser...");
        Cruiser cruiser = new Cruiser(new ArrayList<Position>(Arrays.asList(getCoordinates(4))));

        // battleship
        System.out.println("Place battleship...");
        Battleship battleship = new Battleship(new ArrayList<Position>(Arrays.asList(getCoordinates(5))));

        // carrier (x2)
        System.out.println("Place carrier...");
        Carrier carrier = new Carrier(new ArrayList<Position>(Arrays.asList(getCoordinates(3))));

        System.out.println("Place carrier...");
        Carrier carrier2 = new Carrier(new ArrayList<Position>(Arrays.asList(getCoordinates(3))));
         */
    }

    @Override
    public void ShowCoordinates() {

    }

    @Override
    public void shoot() {

    }
}
