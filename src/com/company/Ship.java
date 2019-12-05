package com.company;

import com.company.Position;
import java.util.ArrayList;

public abstract class Ship {
    private ArrayList<Position> positions;
    private int size;
    private int hits;

    public Ship(ArrayList<Position> positions) {      // en konstruktor som tar emot ArrayList position
        this.positions = positions;

    }

    public Ship() {
        positions = new ArrayList<Position>();
    }

    public abstract int getSize();

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public boolean hit(Position attackPosition) {        // tar emot ett argument, positionen som spelaren skjutit mot
        for (Position position : positions) {           // ett skepp kan bestå av flera rutor på spelplanen, vi går igenom positionerna i skeppet
            if (attackPosition.getX() == position.getX() && attackPosition.getY() == position.getY()) {
                return true;

                // Jämfört om attackpositionen stämmer överrens med skeppet som den andra spelaren har, då har det blivit en träff där

            }

        }
        return false;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public abstract void wasHit();                    // metod som implementeras av underklasserna
}






