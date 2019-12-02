package com.company;

public abstract class Player {
    private String name;
    private Map map;

    public Player(String name, Map map) {
        this.name = name;
        this.map = map;
    }

    public abstract void placeShips();

    public abstract void ShowCoordinates();

    public abstract void shoot();
}

