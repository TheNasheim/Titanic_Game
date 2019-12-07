package com.company;



import java.util.ArrayList;

public class Computer extends Player {
    //private Position lastPosition;
    int xSize;
    int ySize;
    public Computer(String name, int id, BoardGame map){
        super(name, id, map);
    }




    //
    @Override
    public void placeShips() {
        for (Ship ship : getStartingShips())
            do {
                ship.setPositions(getCoordinates(ship.getSize()));
            } while (!getMap().addShip(ship));
        System.out.println(getName() + " has placed out all its ships.");
    }

    //
    private ArrayList<Position> getCoordinates(int shipSize) {
        int x;
        int y;
        boolean horizontal;

        int alignment = (int) Math.round(Math.random());
        horizontal = alignment != 0;

        // x-coordinate
        while (true) {
            try {
                x = (int) Math.round(Math.random() * getMap().getXSize());
            } catch (NumberFormatException e) {
                continue;
            }
            break;
        }

        // y-coordinate
        while (true) {
            try {
                y = (int)Math.round(Math.random() * getMap().getYSize());
            } catch (NumberFormatException e) {
                continue;
            }
            break;
        }

        ArrayList<Position> positions = new ArrayList<Position>();
        for (int i = 0; i < shipSize; i++) {
            if (horizontal) {
                positions.add(new Position(x + i, y));
            } else { // vertical
                positions.add(new Position(x, y + i));
            }
        }

        return positions;
    }


    // This is just so Mr.Potato can hav a 20% chance to hit his own map by mistake. ;)
    @Override
    public int selectOpponentPlayer() {
        if(getName().equals("Mr.Potato")) {
            if(Math.random() > 0.8) {
                System.out.println("Oh no.. Im shooting at myself.");
                return 1;
            }
            else
                return 0;
        }
        return 0;
    }



    @Override
    public Position shoot() {

        Position position = new Position((int)(Math.round((Math.random() * getMap().getXSize()))),(int)Math.round(Math.random() * getMap().getYSize()));
        System.out.println("Im shooting at X:" + (position.getX()+1) + " & Y:" + (position.getY()+1));
        // TODO: add a smarter computer
        return position;
    }





    @Override
    public int getShipsLeft() {
        return getMap().getShipsLeft();
    }

}
