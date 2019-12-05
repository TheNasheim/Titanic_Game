package com.company;

import java.util.ArrayList;

public class Battleship extends Ship {

    public Battleship(ArrayList<Position> positions) {
        super(positions);
    }

    public Battleship() { super(5); }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public boolean wasSunk() {
        if(getSize() == getHits())
            System.out.println("You sank a " + this.toString());
        return getSize() == getHits();
    }



    @Override
    public String toString() {
        return "Battleship";
    }
}
