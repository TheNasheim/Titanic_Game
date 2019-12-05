package com.company;

import java.util.ArrayList;

public class Carrier extends Ship {
    // extends Ship (Superclass)

    public Carrier(ArrayList<Position> positions) {
        //constructor

        super(positions);
    }

    public Carrier() {}

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public void wasHit() {

    }

    @Override
    public String toString() {
        return "Carrier";
    }
}
