package com.company;

import java.util.Random;

public class Computer extends Player {

    public Computer(String name,BoardGame map){
        super(name,map);
    }


    @Override
    public void placeShips() {

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
        Random randomCoordinate  = new Random();
        int toX, toY;

        toX = randomCoordinate.nextInt(10);
        toY = randomCoordinate.nextInt(10);

        return new Position(toX+1,toY+1);
    }

    @Override
    public int getShipsLeft() {
        return 0;
    }

    @Override
    public String toString() {
        return "Player " + getName();
    }
}
