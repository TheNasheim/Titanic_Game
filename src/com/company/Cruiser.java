package com.company;

import java.util.ArrayList;

public class Cruiser extends Ship {

    public Cruiser(ArrayList<Position> positions) {
        super(positions);
    }

    public Cruiser() {}

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public void wasHit() {

    }
}
