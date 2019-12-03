package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player {
    private BoardGame boardGame;

    public Human(String name, BoardGame map) {
        super(name, map);
    }

    private ArrayList<Position> getCoordinates(int shipSize) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        boolean horizontal;

        // horizontal or vertical
        while(true) {
            System.out.print("[h]orizontal or [v]ertical: ");
            String alignment = scanner.nextLine().toLowerCase();

            if(alignment.equals("v") || alignment.equals("vertical")) {
                horizontal = false;
            }
            else if(alignment.equals("h") || alignment.equals("horizontal")) {
                horizontal = true;
            }
            else {
                System.out.println("ERROR: You have to enter [h]orizontal or [v]ertical. Try again!");
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

        ArrayList<Position> positions = new ArrayList<Position>();

        for (int i = 0; i < shipSize; i++) {
            if(horizontal) {
                positions.add(new Position(x + i, y));
            }
            else { // vertical
                positions.add(new Position(x, y + i));
            }
        }

        return positions;
    }

    @Override
    public void placeShips() {
        for (Ship ship : getStartingShips()) {
            do {
                System.out.println("Place" + ship + "...");
                ship.setPositions(getCoordinates(ship.getSize()));
                if (getMap().addShip(ship)) {
                    break; // ship was added successfully
                } else {
                    System.out.println("ERROR: Can't place ship there. Try again!");
                }
            } while(true);
        }
    }

    @Override
    public int selectOponentPlayer() {
        return 0;
    }

    @Override
    public void ShowCoordinates() {

    }

    @Override
    public Position shoot() {
        Scanner input = new Scanner(System.in);
        // get players name . get Nap . boolean shotAtPosition(Position position[new toX,toY])
        int toX, toY;
        System.out.println("Enter coordinate X & Y to shoot at");
        toX = input.nextInt();
        toY = input.nextInt();
        return new Position(toX,toY);
    }

    @Override
    public int getShipsLeft() {
        return 0;
    }
}
