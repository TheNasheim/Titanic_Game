package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardGame {

    private SquareState[][] board;
    private ArrayList<Ship> ships;

    // This constructor needs two int values to build up a new boardgame with the desired size.
    public BoardGame(int x, int y){
        ships = new ArrayList<>();
        board = new SquareState[x][y];
        for (SquareState[] squareStates : board) {
            Arrays.fill(squareStates, SquareState.NONE);
        }
    }

    //region addShip()
    // Adding a ship to ships array.
    // This will return a boolean if has collided with another ship
    // or if it is outside the game area
    public boolean addShip(Ship ship){
        boolean fits = true;
        for(Position position : ship.getPositions()) {
            if (position.getX() >= board[0].length || position.getY() >= board.length)
                fits =  false;
            else if (position.getX() < 0 || position.getY() < 0)
                fits =  false;
            else if (shipCollide(position)) {
                fits = false;
            } else {
                fits = true;
            }
        }
        if(fits)
            ships.add(ship);
        return fits;
    }

    // This will check all the other ships that the positions do not collide.
    // else it will return a False.
    private boolean shipCollide(Position position){
        boolean collide = false;
        if(ships.size() != 0) {
            for (Ship ship : ships) {
                ArrayList<Position> positions = ship.getPositions();
                for(Position pos : positions){
                    if (position.getX() == pos.getX() && position.getY() == pos.getY()) {
                        collide = true;
                    }
                }
            }
        }
        return collide;
    }
    //endregion

    // This function is is to fill the arraylist[][] board HIT or MISS from the ships arraylist.
    public boolean shotAtPosition(Position position) {
        if(board[position.getY()][position.getX()] == SquareState.NONE) {
            for (Ship ship : ships) {
                if (ship.hit(position)) {
                    board[position.getY()][position.getX()] = SquareState.HIT;
                } else {
                    board[position.getY()][position.getX()] = SquareState.MISS;
                }
            }
            return true;
        }
        else {
            return false;
        }

    }

    //region Render()
    // This Function renders out the Board with hit miss and empty to console.
    // It also adds the numbers at the column header and row header.
    // A reminder that the first NR is set to 1 so when shooting remember to retract 1 in the int.
    public void render(){
        String display = "";
        display += "[\\]";
        for (int col = 0; col < board[0].length; col++){
            display += "[" + (col + 1) + "]";
        }
        display += "\n";
        for (int row = 0; row < board.length; row++){
            display += "[" + (row + 1) + "]";
            for (int col = 0; col < board[row].length; col++){
                display += squareDesign(board[row][col]);
            }
            display += "\n";
        }
        System.out.printf(display + "\n");
    }

    // This Function returns the SquareState Enum to a nice looking String of a hit, miss, none square.
    private String squareDesign(SquareState squareState){
        String strOut = "";
        switch (squareState){
            case NONE:
                strOut = "[ ]";
                break;
            case HIT:
                strOut = "[X]";
                break;
            case MISS:
                strOut = "[.]";
                break;
        }
        return strOut;
    }

    //endregion

    public int getShipsLeft(){
        return ships.size();
    }
}
