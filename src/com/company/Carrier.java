package com.company;

import java.util.ArrayList;

public class Carrier extends Ship {
    // extends Ship (Superclass)

    public Carrier(ArrayList<Position> positions) {
        //constructor

        super(positions);
    }

    @Override
    public void wasHit() {

    }
}