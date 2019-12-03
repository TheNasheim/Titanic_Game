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
}
