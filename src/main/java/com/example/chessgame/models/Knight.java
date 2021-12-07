package com.example.chessgame.models;

import com.example.chessgame.controllers.ChessBoardController;
import javafx.event.ActionEvent;

public class Knight extends Piece{
    public Knight(String color, int row, int column) {
        super(color, row, column);
    }
    public boolean ate = false;

    @Override
    public boolean isMovementValid(int row, int col, int rowTarget, int colTarget) {
        int[] X = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] Y = {1, 2, 2, 1, -1, -2, -2, -1};

        if(row == rowTarget && col == colTarget) {
            return false;
        }

        for (int j = 0; j < 8; j++) {
            int x = row + X[j];
            int y = col + Y[j];

            if((x == rowTarget) && (y == colTarget)) {
                if(ChessBoardController.board.boardMap[rowTarget][colTarget] != null) {
                    if(!ChessBoardController.board.boardMap[rowTarget][colTarget].getColor().equals(ChessBoardController.board.boardMap[row][col].getColor())) {
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

        }

        return false;
    }



    @Override
    public String toString() {
        return  getColor().toUpperCase() + " KNIGHT";
    }
}
