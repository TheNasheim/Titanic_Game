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

    public Submarine() {}

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public void wasHit() {
        //change behavior that exist in the superclass 

    }

    @Override
    public String toString() {
        return "Submarine";
    }
}
