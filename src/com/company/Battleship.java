package com.company;

import java.util.ArrayList;

public class Battleship extends Ship {

    public Battleship(ArrayList<Position> positions) {
        super(positions);
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public void wasHit() {

    }
}
