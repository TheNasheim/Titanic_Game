package com.company;

public abstract class Player {
    private String name;
    private BoardGame map;

    public Player(String name, BoardGame map) {
        this.name = name;
        this.map = map;
    }

    public abstract void placeShips();

    public abstract int selectOponentPlayer();

    public abstract void ShowCoordinates();

    public abstract Position shoot();

    public BoardGame getMap() {
        return map;
    }

    public void displayMap() {
        map.render();
    }

    public boolean shotAtPosition(Position position) {
        return map.shotAtPosition(position);
    }

    Ship[] getStartingShips() {
        return new Ship[]{
                new Submarine(),
                new Destroyer(),
                new Cruiser(),
                new Battleship(),
                new Carrier(),
                new Carrier()
        };
    }
}

