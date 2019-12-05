package com.company;

public abstract class Player {
    private String name;
    private BoardGame map;
    private int id;

    public Player(String name, int id, BoardGame map) {
        this.name = name;
        this.id = id;
        this.map = map;
    }

    public abstract void placeShips();

    public abstract int selectOponentPlayer();

    public abstract Position shoot();

    public String getName() {
        return name;
    }

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

    public SquareState shotAtPosition(Position position) {
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

