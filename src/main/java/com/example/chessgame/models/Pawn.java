package com.example.chessgame.models;

import com.example.chessgame.controllers.ChessBoardController;

public class Pawn extends Piece{
    private int moves = 0;
    public boolean ate = false;

    public Pawn(String color, int row, int column) {
        super(color, row, column);
    }

    @Override
    public boolean isMovementValid(int row, int col, int rowTarget, int colTarget) {
        int i;

        if(ChessBoardController.board.boardMap[row][col].getColor().equals("black")) {
            i = 1;
        } else {
            i = -1;
        }

        int rowMovement = rowTarget - row;
        int colMovement = colTarget - col;

        if(row == rowTarget && col == colTarget) {
            return false;
        }

        boolean isAbleToCapture = (Math.abs(rowMovement) == 1 && (colMovement == 1 || colMovement == -1));
        boolean isMovingBackwards = (row + (-i) == rowTarget);

        if(!isMovingBackwards) {
            if(isAbleToCapture) {
                if(ChessBoardController.board.boardMap[rowTarget][colTarget] != null) {
                    if(colMovement == 1 && !(ChessBoardController.board.boardMap[row][col].getColor().equals(ChessBoardController.board.boardMap[rowTarget][colTarget].getColor()))) {
                        ate = true;

                        return true;
                    } else if(colMovement == -1 && !(ChessBoardController.board.boardMap[row][col].getColor().equals(ChessBoardController.board.boardMap[rowTarget][colTarget].getColor()))) {
                        ate = true;

                        return true;
                    }
                }
            }
        }

        if(ChessBoardController.board.boardMap[rowTarget][col] != null) {
            return false;
        }

        if(ChessBoardController.board.boardMap[row + i][col] != null) {
            return false;
        }

        if(this.getMoves() == 0) {
            if(this.getColor().equals("black")) {
                ate = false;

                return (rowTarget - row <= 2) && (col == colTarget);
            } else {
                ate = false;

                return (rowTarget - row >= -2) && (col == colTarget);
            }
        } else {
            if(this.getColor().equals("black")) {
                ate = false;

                return (rowTarget - row == 1) && (col == colTarget);
            } else {
                ate = false;

                return (rowTarget - row == -1) && (col == colTarget);
            }
        }
    }

    @Override
    public String toString() {
        return getColor().toUpperCase() + " PAWN";
    }

    public int getMoves() {
        return moves;
    }

    public void incrementMoves() {
        this.moves++;
    }
}
