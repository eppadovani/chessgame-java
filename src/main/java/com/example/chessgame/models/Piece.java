package com.example.chessgame.models;

import javafx.event.ActionEvent;

public abstract class Piece {

    private String color;
    private int row, column;

    public Piece(String color, int row, int column) {
        this.color = color;
        this.row = row;
        this.column = column;
    }

    //Futuro ter uma func como essa
//    public abstract void moves(int row, int col, int rowTarget, int colTarget);

    public abstract boolean isMovementValid(int row, int col, int rowTarget, int colTarget);

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }
}
