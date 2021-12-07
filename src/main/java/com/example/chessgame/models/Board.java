package com.example.chessgame.models;

import com.example.chessgame.controllers.ChessBoardController;
import javafx.scene.layout.GridPane;

public class Board {

    public Piece[][] boardMap;

    public void move(int row, int col, int rowTarget, int colTarget) {
        ChessBoardController.board.boardMap[rowTarget][colTarget] = ChessBoardController.board.boardMap[row][col];
    }

    public void clearPossiblePath(Piece piece, int row, int col) {
        if(piece instanceof Pawn) {
            if(piece.getColor().equals("black")) {
                if(((Pawn) piece).getMoves() == 0) {
                    for (int i = 1; i < 3; i++) {
                        ChessBoardController.boardButtons[row + i][col].getStyleClass().remove("board-button-path");
                    }
                } else {
                    if(row + 1 != 8) {
                        ChessBoardController.boardButtons[row + 1][col].getStyleClass().remove("board-button-path");
                    }
                }
            } else {
                if(((Pawn) piece).getMoves() == 0) {
                    for (int i = 1; i < 3; i++) {
                        ChessBoardController.boardButtons[row - i][col].getStyleClass().remove("board-button-path");
                    }
                } else {
                    if(row - 1 != -1) {
                        ChessBoardController.boardButtons[row - 1][col].getStyleClass().remove("board-button-path");
                    }
                }
            }
        } else if(piece instanceof Rook) {
            //front row
            for(int j = 1; j < 8; j++) {
                if(0 <= row + j && row + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col] == null) {
                        ChessBoardController.boardButtons[row + j][col].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //back row
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && row - j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col] == null) {
                        ChessBoardController.boardButtons[row - j][col].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //right column
            for(int j = 1; j < 8; j++) {
                if(0 <= col + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row][col + j] == null) {
                        ChessBoardController.boardButtons[row][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //left column
            for(int j = 1; j < 8; j++) {
                if(0 <= col - j && col - j <= 7) {
                    if(ChessBoardController.board.boardMap[row][col - j] == null) {
                        ChessBoardController.boardButtons[row][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        } else if(piece instanceof Bishop) {
            //lower right diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col + j] == null) {
                        ChessBoardController.boardButtons[row + j][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper right diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col + j] == null) {
                        ChessBoardController.boardButtons[row - j][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper left diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row - j][col - j] == null) {
                        ChessBoardController.boardButtons[row - j][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower left diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row + j][col - j] == null) {
                        ChessBoardController.boardButtons[row + j][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        } else if(piece instanceof Queen) {
            //lower right diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col + j] == null) {
                        ChessBoardController.boardButtons[row + j][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper right diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col + j] == null) {
                        ChessBoardController.boardButtons[row - j][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper left diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row - j][col - j] == null) {
                        ChessBoardController.boardButtons[row - j][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower left diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row + j][col - j] == null) {
                        ChessBoardController.boardButtons[row + j][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //front row
            for(int j = 1; j < 8; j++) {
                if(0 <= row + j && row + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col] == null) {
                        ChessBoardController.boardButtons[row + j][col].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //back row
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && row - j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col] == null) {
                        ChessBoardController.boardButtons[row - j][col].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //right column
            for(int j = 1; j < 8; j++) {
                if(0 <= col + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row][col + j] == null) {
                        ChessBoardController.boardButtons[row][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //left column
            for(int j = 1; j < 8; j++) {
                if(0 <= col - j && col - j <= 7) {
                    if(ChessBoardController.board.boardMap[row][col - j] == null) {
                        ChessBoardController.boardButtons[row][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        } else if(piece instanceof Knight) {
            int[] X = {2, 1, -1, -2, -2, -1, 1, 2};
            int[] Y = {1, 2, 2, 1, -1, -2, -2, -1};

            for (int j = 0; j < 8; j++) {
                int x = row + X[j];
                int y = col + Y[j];

                if(x >= 0 && y >= 0 && x < 8 && y < 8 && ChessBoardController.board.boardMap[x][y] == null) {
                    ChessBoardController.boardButtons[x][y].getStyleClass().remove("board-button-path");
                }
            }
        } else if(piece instanceof King) {
            //lower right diagonal
            for(int j = 1; j < 2; j++) {
                if(7 >= row + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col + j] == null) {
                        ChessBoardController.boardButtons[row + j][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper right diagonal
            for(int j = 1; j < 2; j++) {
                if(0 <= row - j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col + j] == null) {
                        ChessBoardController.boardButtons[row - j][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper left diagonal
            for(int j = 1; j < 2; j++) {
                if(0 <= row - j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row - j][col - j] == null) {
                        ChessBoardController.boardButtons[row - j][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower left diagonal
            for(int j = 1; j < 2; j++) {
                if(7 >= row + j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row + j][col - j] == null) {
                        ChessBoardController.boardButtons[row + j][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //front row
            for(int j = 1; j < 2; j++) {
                if(row + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col] == null) {
                        ChessBoardController.boardButtons[row + j][col].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //back row
            for(int j = 1; j < 2; j++) {
                if(0 <= row - j && row - j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col] == null) {
                        ChessBoardController.boardButtons[row - j][col].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //right column
            for(int j = 1; j < 2; j++) {
                if(col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row][col + j] == null) {
                        ChessBoardController.boardButtons[row][col + j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //left column
            for(int j = 1; j < 2; j++) {
                if(0 <= col - j && col - j <= 7) {
                    if(ChessBoardController.board.boardMap[row][col - j] == null) {
                        ChessBoardController.boardButtons[row][col - j].getStyleClass().remove("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void showPossiblePath(Piece piece, int row, int col) {
        int i;

        if(piece.getColor().equals("black")) {
            i = 1;
        } else {
            i = -1;
        }

        if(piece instanceof Pawn) {
            if(piece.getRow() != 7 || piece.getRow() != 0) {
                if(((Pawn) piece).getMoves() == 0) {
                    if(ChessBoardController.board.boardMap[row + i][col] == null && ChessBoardController.board.boardMap[row + (2 * i)][col] == null) {
                        ChessBoardController.boardButtons[row + i][col].getStyleClass().add("board-button-path");
                        ChessBoardController.boardButtons[row + (2 * i)][col].getStyleClass().add("board-button-path");


                    } else if(ChessBoardController.board.boardMap[row + i][col] == null && ChessBoardController.board.boardMap[row + (2 * i)][col] != null) {
                        ChessBoardController.boardButtons[row + i][col].getStyleClass().add("board-button-path");

                    }
                } else {
                    if(row + i != 8 && row + i != -1) {
                        if(ChessBoardController.board.boardMap[row + i][col] == null)
                            ChessBoardController.boardButtons[row + i][col].getStyleClass().add("board-button-path");
                    }
                }
            }
        } else if(piece instanceof Rook) {
            //front row
            for(int j = 1; j < 8; j++) {
                if(0 <= row + (i*j) && row + (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row + (i*j)][col] == null) {
                        ChessBoardController.boardButtons[row + (i*j)][col].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //back row
            for(int j = 1; j < 8; j++) {
                if(0 <= row - (i*j) && row - (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row - (i*j)][col] == null) {
                        ChessBoardController.boardButtons[row - (i*j)][col].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //right column
            for(int j = 1; j < 8; j++) {
                if(0 <= col + (i*j) && col + (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row][col + (i*j)] == null) {
                        ChessBoardController.boardButtons[row][col + (i*j)].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //left column
            for(int j = 1; j < 8; j++) {
                if(0 <= col - (i*j) && col - (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row][col - (i*j)] == null) {
                        ChessBoardController.boardButtons[row][col - (i*j)].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        } else if(piece instanceof Bishop) {
            //lower right diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col + j] == null) {
                        ChessBoardController.boardButtons[row + j][col + j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper right diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col + j] == null) {
                        ChessBoardController.boardButtons[row - j][col + j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper left diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row - j][col - j] == null) {
                        ChessBoardController.boardButtons[row - j][col - j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower left diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row + j][col - j] == null) {
                        ChessBoardController.boardButtons[row + j][col - j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        } else if(piece instanceof Queen) {
            //front row
            for(int j = 1; j < 8; j++) {
                if(0 <= row + (i*j) && row + (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row + (i*j)][col] == null) {
                        ChessBoardController.boardButtons[row + (i*j)][col].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //back row
            for(int j = 1; j < 8; j++) {
                if(0 <= row - (i*j) && row - (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row - (i*j)][col] == null) {
                        ChessBoardController.boardButtons[row - (i*j)][col].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //right column
            for(int j = 1; j < 8; j++) {
                if(0 <= col + (i*j) && col + (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row][col + (i*j)] == null) {
                        ChessBoardController.boardButtons[row][col + (i*j)].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //left column
            for(int j = 1; j < 8; j++) {
                if(0 <= col - (i*j) && col - (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row][col - (i*j)] == null) {
                        ChessBoardController.boardButtons[row][col - (i*j)].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower right diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col + j] == null) {
                        ChessBoardController.boardButtons[row + j][col + j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper right diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col + j] == null) {
                        ChessBoardController.boardButtons[row - j][col + j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper left diagonal
            for(int j = 1; j < 8; j++) {
                if(0 <= row - j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row - j][col - j] == null) {
                        ChessBoardController.boardButtons[row - j][col - j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower left diagonal
            for(int j = 1; j < 8; j++) {
                if(7 >= row + j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row + j][col - j] == null) {
                        ChessBoardController.boardButtons[row + j][col - j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        } else if(piece instanceof Knight) {
            int[] X = {2, 1, -1, -2, -2, -1, 1, 2};
            int[] Y = {1, 2, 2, 1, -1, -2, -2, -1};

            for (int j = 0; j < 8; j++) {
                int x = row + X[j];
                int y = col + Y[j];

                if(x >= 0 && y >= 0 && x < 8 && y < 8 && ChessBoardController.board.boardMap[x][y] == null) {
                    ChessBoardController.boardButtons[x][y].getStyleClass().add("board-button-path");
                }
            }
        } else if(piece instanceof King) {
            //front row
            for(int j = 1; j < 2; j++) {
                if(0 <= row + (i*j) && row + (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row + (i*j)][col] == null) {
                        ChessBoardController.boardButtons[row + (i*j)][col].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //back row
            for(int j = 1; j < 2; j++) {
                if(0 <= row - (i*j) && row - (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row - (i*j)][col] == null) {
                        ChessBoardController.boardButtons[row - (i*j)][col].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //right column
            for(int j = 1; j < 2; j++) {
                if(0 <= col + (i*j) && col + (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row][col + (i*j)] == null) {
                        ChessBoardController.boardButtons[row][col + (i*j)].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //left column
            for(int j = 1; j < 2; j++) {
                if(0 <= col - (i*j) && col - (i*j) <= 7) {
                    if(ChessBoardController.board.boardMap[row][col - (i*j)] == null) {
                        ChessBoardController.boardButtons[row][col - (i*j)].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower right diagonal
            for(int j = 1; j < 2; j++) {
                if(7 >= row + j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row + j][col + j] == null) {
                        ChessBoardController.boardButtons[row + j][col + j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper right diagonal
            for(int j = 1; j < 2; j++) {
                if(0 <= row - j && col + j <= 7) {
                    if(ChessBoardController.board.boardMap[row - j][col + j] == null) {
                        ChessBoardController.boardButtons[row - j][col + j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //upper left diagonal
            for(int j = 1; j < 2; j++) {
                if(0 <= row - j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row - j][col - j] == null) {
                        ChessBoardController.boardButtons[row - j][col - j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }

            //lower left diagonal
            for(int j = 1; j < 2; j++) {
                if(7 >= row + j && col - j >= 0) {
                    if(ChessBoardController.board.boardMap[row + j][col - j] == null) {
                        ChessBoardController.boardButtons[row + j][col - j].getStyleClass().add("board-button-path");
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public Board() {
        this.boardMap = new Piece[8][8];
    }
}
