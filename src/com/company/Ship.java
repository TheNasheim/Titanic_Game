package com.company;

import javax.swing.text.Position;
import java.util.ArrayList;

public abstract class Ship {
    private ArrayList<Position> positions;
    private int size;
    private int hits;

    public Ship(ArrayList<Position> positions) {
        this.positions = positions;

    }


}
