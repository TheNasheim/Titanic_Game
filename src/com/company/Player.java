package com.company;

import java.util.Map;

public abstract class Player {
    private String name;
    private Map map;

    public Player(String name, Map map) {
        this.name = name;
        this.map = map;
    }

    public void placeShips() {

    }

    public void ShowCoordinates() {
    }

    public void shoot() {

    }
}

