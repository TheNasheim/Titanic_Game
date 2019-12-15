package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardGame {

    private SquareState[][] board;
    private ArrayList<Ship> ships;

    // This constructor needs two int values to build up a new boardgame with the desired size.
    public BoardGame(int x, int y){
        ships = new ArrayList<>();
        board = new SquareState[y][x];
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
            if (position.getX() >= board[0].length || position.getY() >= board.length) {
                fits = false;
                break;
            }
            else if (position.getX() < 0 || position.getY() < 0){
                fits =  false;
            break;
            }
            else if (shipCollide(position)) {
                fits = false;
                break;
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
    public SquareState shotAtPosition(Position position) {
        SquareState state = SquareState.NONE;
        if(position.getY() < board.length && position.getX() < board[0].length)  {
            if(position.getY() >= 0 && position.getX() >= 0) {
                if (board[position.getY()][position.getX()] == SquareState.NONE) {
                    for (Ship ship : ships) {
                        state = SquareState.MISS;
                        if (ship.hit(position)) {
                            board[position.getY()][position.getX()] = SquareState.HIT;
                            if (ship.wasSunk()) {
                                ships.remove(ship);
                            }
                            state = SquareState.HIT;
                            break;
                        } else {
                            board[position.getY()][position.getX()] = SquareState.MISS;
                        }
                    }
                }

            }
        }
        return state;
    }

    // This will render a map of all the players ships on the map
    // So user can see were the ships are on the player board.
    public void renderMyMap(){
       SquareState[][] myPlayerBoard = new SquareState[board.length][board[0].length];
        for (SquareState[] squareStates : myPlayerBoard) {
            Arrays.fill(squareStates, SquareState.NONE);
        }
        if(ships.size() > 0){
            System.out.println("Ive found " + ships.size() + "ship");
            for(Ship ship : ships){
                ArrayList<Position> positions = ship.getPositions();
                for(Position position : positions){
                    myPlayerBoard[position.getY()][position.getX()] = SquareState.HIT;
                }
            }
        }
        String display = "";
        display += "[\\]";
        for (int col = 0; col < myPlayerBoard[0].length; col++){
            display += "[" + (col + 1) + "]";
        }
        display += "\n";
        for (int row = 0; row < myPlayerBoard.length; row++){
            display += "[" + (row + 1) + "]";
            for (int col = 0; col < myPlayerBoard[row].length; col++){
                display += squareDesign(myPlayerBoard[row][col]);
            }
            display += "\n";
        }
        System.out.printf(display + "\n");
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

    // this will return the amount of ships player has left.
    public int getShipsLeft(){
        return ships.size();
    }
    // This will return the board height Y
    public int getYSize() {
        return board.length -1;
    }
    // This will return the board Width X
    public int getXSize() {
        return board[0].length - 1;
    }
}
