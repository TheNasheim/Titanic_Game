package com.company;

import java.util.ArrayList;

public class Carrier extends Ship {
    // extends Ship (Superclass)

    public Carrier(ArrayList<Position> positions) {
        //constructor

        super(positions);
    }

    public Carrier() { super(3);}

    @Override
    public boolean wasSunk() {
        if(getSize() == getHits())
            System.out.println("You sank a " + this.toString());
        return getSize() == getHits();
    }


    @Override
    public String toString() {
        return "Carrier";
    }
}
