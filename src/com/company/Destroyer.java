package com.company;

import java.util.ArrayList;

public class Destroyer extends Ship {
    public Destroyer(ArrayList<Position> positions) {
        super(positions);
    }

    public Destroyer() {}

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public void wasHit() {

    }

    @Override
    public String toString() {
        return "Destroyer";
    }
}
