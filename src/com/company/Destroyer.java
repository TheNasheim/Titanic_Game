package com.company;

import java.util.ArrayList;

public class Destroyer extends Ship {
    public Destroyer(ArrayList<Position> positions) {
        super(positions);
    }

    public Destroyer() { super(2);}

    @Override
    public boolean wasSunk() {
        if(getSize() == getHits())
            System.out.println("You sank a " + this.toString());
        return getSize() == getHits();
    }


    @Override
    public String toString() {
        return "Destroyer";
    }
}
