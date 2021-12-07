package com.example.chessgame.models;

import com.example.chessgame.controllers.ChessBoardController;
import javafx.event.ActionEvent;

public class Bishop extends Piece{
    public Bishop(String color, int row, int column) {
        super(color, row, column);
    }
    public boolean ate = false;

    @Override
    public boolean isMovementValid(int row, int col, int rowTarget, int colTarget) {
        int rowMovement, colMovement;
        rowMovement = rowTarget - row;
        colMovement = colTarget - col;

        if(row == rowTarget && col == colTarget) {
            return false;
        }

        if(Math.abs(rowMovement) != Math.abs(colMovement)) {
            return false;
        }

        if(rowMovement < 0 && colMovement < 0) {
            for(int i = row - 1, j = col - 1; (i > rowTarget) && (j > colTarget); i--, j--) {
                if(ChessBoardController.board.boardMap[i][j] != null) {
                    return false;
                }
            }

            if(ChessBoardController.board.boardMap[rowTarget][colTarget] != null) {
                if(!ChessBoardController.board.boardMap[rowTarget][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                    ChessBoardController.moves = 0;

                    ate = true;
                    return true;
                } else {
                    return false;
                }
            }
        }

        if(rowMovement < 0 && colMovement > 0) {
            for(int i = row - 1, j = col + 1; (i > rowTarget) && (j < colTarget); i--, j++) {
                if(ChessBoardController.board.boardMap[i][j] != null) {
                    return false;
                }
            }

            if(ChessBoardController.board.boardMap[rowTarget][colTarget] != null) {
                if(!ChessBoardController.board.boardMap[rowTarget][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                    ChessBoardController.moves = 0;

                    ate = true;
                    return true;
                } else {
                    return false;
                }
            }
        }

        if(rowMovement > 0 && colMovement > 0) {
            for(int i = row + 1, j = col + 1; (i < rowTarget) && (j < colTarget); i++, j++) {
                if(ChessBoardController.board.boardMap[i][j] != null) {
                    return false;
                }
            }

            if(ChessBoardController.board.boardMap[rowTarget][colTarget] != null) {
                if(!ChessBoardController.board.boardMap[rowTarget][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                    ChessBoardController.moves = 0;

                    ate = true;
                    return true;
                } else {
                    return false;
                }
            }
        }

        if(rowMovement > 0 && colMovement < 0) {
            for(int i = row + 1, j = col - 1; (i < rowTarget) && (j > colTarget); i++, j--) {
                if(ChessBoardController.board.boardMap[i][j] != null) {
                    return false;
                }
            }

            if(ChessBoardController.board.boardMap[rowTarget][colTarget] != null) {
                if(!ChessBoardController.board.boardMap[rowTarget][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                    ChessBoardController.moves = 0;

                    ate = true;
                    return true;
                } else {
                    return false;
                }
            }
        }


        ChessBoardController.moves += 1;
        return true;
    }


    @Override
    public String toString() {
        return  getColor().toUpperCase() + " BISHOP";
    }
}
