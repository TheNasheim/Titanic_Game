package com.company;

// import

import java.util.ArrayList;

public class Submarine extends Ship {
//extends Ship (superclass)

    public Submarine(ArrayList<Position> positions) {
        //this is a constructor takes in ArrayList<Position>
        super(positions);
        // send up ArrayList to super
    }

    public Submarine() { super(3);}

    /*@Override
    public int getSize() {
        return 3;
    }*/

    @Override
    public boolean wasSunk() {
        if(getSize() == getHits())
            System.out.println("You sank a " + this.toString());
        return getSize() == getHits();
    }


    @Override
    public String toString() {
        return "Submarine";
    }
}
