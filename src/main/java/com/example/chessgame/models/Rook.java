package com.example.chessgame.models;

import com.example.chessgame.controllers.ChessBoardController;
import javafx.event.ActionEvent;

public class Rook extends Piece{
    public Rook(String color, int row, int column) {
        super(color, row, column);
    }
    public boolean ate = false;

    @Override
    public boolean isMovementValid(int row, int col, int rowTarget, int colTarget) {

        if(row == rowTarget && col == colTarget) {
            return false;
        }

        if(row == rowTarget) {
            if(col < colTarget) {
                for(int j = col + 1; j < colTarget; j++) {
                    if(ChessBoardController.board.boardMap[row][j] != null) {
                        return false;
                    }
                }

                if(ChessBoardController.board.boardMap[row][colTarget] != null) {
                    if(!ChessBoardController.board.boardMap[row][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                        ChessBoardController.moves = 0;

                        ate = true;
                        return true;
                    } else {
                        return false;
                    }
                }

                ChessBoardController.moves += 1;
                return true;

            } else {
                for(int j = col - 1; j > colTarget; j--) {
                    if(ChessBoardController.board.boardMap[row][j] != null) {
                        return false;
                    }
                }

                if(ChessBoardController.board.boardMap[row][colTarget] != null) {
                    if(!ChessBoardController.board.boardMap[row][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                        ChessBoardController.moves = 0;

                        ate = true;
                        return true;
                    } else {
                        return false;
                    }
                }

                ChessBoardController.moves += 1;
                return true;
            }
        } else if(col == colTarget) {
            if(row < rowTarget) {
                for(int j = row + 1; j < rowTarget; j++) {
                    if(ChessBoardController.board.boardMap[j][col] != null) {
                        return false;
                    }
                }

                if(ChessBoardController.board.boardMap[rowTarget][col] != null) {
                    if(!ChessBoardController.board.boardMap[rowTarget][col].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                        ChessBoardController.moves = 0;

                        ate = true;
                        return true;
                    } else {
                        return false;
                    }
                }

                ChessBoardController.moves += 1;
                return true;

            } else {
                for(int j = row - 1; j > rowTarget; j--) {
                    if(ChessBoardController.board.boardMap[j][col] != null) {
                        return false;
                    }
                }

                if(ChessBoardController.board.boardMap[rowTarget][col] != null) {
                    if(!ChessBoardController.board.boardMap[rowTarget][col].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
                        ChessBoardController.moves = 0;

                        ate = true;
                        return true;
                    } else {
                        return false;
                    }
                }

                ChessBoardController.moves += 1;
                return true;

            }
        } else {
            return false;
        }
    }



    @Override
    public String toString() {
        return  getColor().toUpperCase() + " ROOK";
    }
}
