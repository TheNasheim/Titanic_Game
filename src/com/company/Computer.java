package com.company;



import java.util.Random;

public class Computer extends Player {
    private Position lastPosition;

    public Computer(String name, int id, BoardGame map){
        super(name, id, map);
    }


    @Override
    public void placeShips() {

    }

    @Override
    public int selectOponentPlayer() {
        return 0;
    }



    @Override
    public Position shoot() {
        Position position = new Position(1,1);
        //Hard *Crasy
        if(getName().equals("GLaDOS")) {

        }
        //Half smart?
        else if(getName().equals("medium")){

        }
        //dumb
        else {

        }

        return position;
    }





    @Override
    public int getShipsLeft() {
        return 0;
    }

}
