package com.company;

public abstract class Player {
    private String name;
    private BoardGame map;

    public Player(String name, BoardGame map) {
        this.name = name;
        this.map = map;
    }

    public abstract void placeShips();

    public abstract void ShowCoordinates();

    public abstract void shoot();

    public BoardGame getMap() {
        return map;
    }
}

