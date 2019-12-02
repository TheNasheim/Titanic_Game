package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardGame {

    private SquareState[][] board;
    private ArrayList<Ship> ships;

    // This constructor needs two int values to build up a new boardgame with the desired size.
    public BoardGame(int x, int y){
        board = new SquareState[x][y];
        for (int row = 0; row < board.length; row++) {
            Arrays.fill(board[row], SquareState.NONE);
        }
    }

    // Adding a ship to ships array.
    public void addShip(Ship ship){
        ships.add(ship);
    }

    // This function is is to fill the arraylist[][] board HIT or MISS from the ships arraylist.
    public boolean shotAtPosition(Position position) {
        if(board[position.getX()][position.getY()] == SquareState.NONE) {
            for (Ship ship : ships) {
                if (ship.hit(position)) {
                    board[position.getX()][position.getY()] = SquareState.HIT;
                } else {
                    board[position.getX()][position.getY()] = SquareState.MISS;
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

}
