package com.company;

public abstract class Player {
    private String name;
    private BoardGame map;
    private int id;

    public Player(String name, int id, BoardGame map) {
        this.name = name;
        this.map = map;
        this.id = id;
    }

    public abstract void placeShips();

    public abstract int selectOponentPlayer();

    public abstract void ShowCoordinates();

    public abstract Position shoot();

    public BoardGame getMap() {
        return map;
    }

    public String getName() {
        return name;
    }

    public void displayMap() {
        map.render();
    }

    public int getId() {
        return id;
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
    public abstract int getShipsLeft();
}

