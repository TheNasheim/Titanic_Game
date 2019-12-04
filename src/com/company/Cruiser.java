package com.company;

import java.util.ArrayList;

public class Cruiser extends Ship {

    public Cruiser(ArrayList<Position> positions) {
        super(positions);
    }

    public Cruiser(int size) { super(size);}

    @Override
    public boolean wasSunk() {
        if(getSize() == getHits())
            System.out.println("You sank a " + this.toString());
        return getSize() == getHits();
    }


    @Override
    public String toString() {
        return "Cruiser";
    }
}
