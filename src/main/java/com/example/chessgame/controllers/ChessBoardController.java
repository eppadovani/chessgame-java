package com.example.chessgame.controllers;

import com.example.chessgame.models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.chessgame.AppScreens.*;

public class ChessBoardController {
	@FXML
	private GridPane chessBoard;

	@FXML
	private Label gameTitle;

	int clicked = 0;
	public static int moves = 0;

	Node currentNode, targetNode;

	static Stage globalStage = new Stage();

	String playerTurn = "white";

	public void switchPlayer() {
		if(playerTurn.equals("white")) {
			playerTurn = "black";
			gameTitle.setText(playerTurn + "'s turn");
		} else {
			playerTurn = "white";
			gameTitle.setText(playerTurn + "'s turn");
		}
	}

	public static Board board = new Board();
	public static Button[][] boardButtons = new Button[8][8];

	public ImageView pieceImage(String url) {
		Image image;
		if (url == null)
			image = null;
		else
			image = new Image(url);
		ImageView imageView = new ImageView(image);

		imageView.setFitWidth(49);
		imageView.setFitHeight(49);

		return imageView;
	}
	public void organizeBlackPieces(Button boardButton, int i, int j) {
		if(i == 1) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/PawnBlack.png"));
			board.boardMap[1][j] = new Pawn("black", i, j);
		}

		else if(i == 0 && (j == 0 || j == 7)) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/RookBlack.png"));
			board.boardMap[0][j] = new Rook("black", i, j);
		}

		else if(i == 0 && (j == 1 || j == 6) ) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/KnightBlack.png"));
			board.boardMap[0][j] = new Knight("black", i, j);
		}

		else if(i == 0 && (j == 2 || j == 5) ) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/BishopBlack.png"));
			board.boardMap[0][j] = new Bishop("black", i, j);
		}

		else if(i == 0 && j == 3) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/QueenBlack.png"));
			board.boardMap[0][j] = new Queen("black", i, j);
		}

		else if(i == 0 && j == 4) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/KingBlack.png"));
			board.boardMap[0][j] = new King("black", i, j);
		}
	}
	public void organizeWhitePieces(Button boardButton, int i, int j) {
		if(i == 6) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/PawnWhite.png"));
			board.boardMap[6][j] = new Pawn("white", i, j);
		}

		else if(i == 7 && (j == 0 || j == 7)) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/RookWhite.png"));
			board.boardMap[7][j] = new Rook("white", i, j);
		}

		else if(i == 7 && (j == 1 || j == 6) ) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/KnightWhite.png"));
			board.boardMap[7][j] = new Knight("white", i, j);
		}

		else if(i == 7 && (j == 2 || j == 5) ) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/BishopWhite.png"));
			board.boardMap[7][j] = new Bishop("white", i, j);
		}

		else if(i == 7 && j == 3) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/QueenWhite.png"));
			board.boardMap[7][j] = new Queen("white", i, j);
		}

		else if(i == 7 && j == 4) {
			boardButton.setGraphic(pieceImage("com/example/chessgame/images/KingWhite.png"));
			board.boardMap[7][j] = new King("white", i, j);
		}
	}

	public void getButtonCoords(ActionEvent actionEvent) {
		Node node = (Node) actionEvent.getSource();
		int col = GridPane.getColumnIndex(node);
		int row = GridPane.getRowIndex(node);

		System.out.println(" " + board.boardMap[row][col] + " (" + row + "," + col + ")");
	}

	public void onButtonSelected(ActionEvent actionEvent) {
		Button boardButton = (Button)actionEvent.getSource();

		int col = GridPane.getColumnIndex(boardButton);
		int row = GridPane.getRowIndex(boardButton);
		String color = "";

		getButtonCoords(actionEvent);

		if(board.boardMap[row][col] != null) {
			color = board.boardMap[row][col].getColor();
		}


			if(clicked == 0) {
				System.out.println(color);

				if(!color.equals(playerTurn)) {
					return;
				}

				currentNode = boardButton;

				if(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)] != null) {
					board.showPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));
					boardButton.getStyleClass().add("board-button");

					clicked = 1;
				}
			} else {
				targetNode = boardButton;
				try {
					moving(actionEvent);
				} catch (IOException e) {
					e.printStackTrace();
				}
				clicked = 0;

				boardButton.getStyleClass().remove("board-button");
				board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

			}
	}

	public Button createButton(int i, int j) {
		Button boardButton = new Button();
		boardButton.setGraphic(pieceImage(null));

		boardButton.setOnAction(event -> {
			onButtonSelected(event);
		});

		boardButton.setPrefSize(79, 79);

		if((i + j) % 2 == 0) {
			boardButton.setStyle("-fx-background-color: #d9b278;");
		} else {
			boardButton.setStyle("-fx-background-color: #74361E;");
		}

		return boardButton;
	}

	public void fillChessBoard(GridPane chessBoard) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				Button button = createButton(i, j);
				boardButtons[i][j] = button;

				organizeBlackPieces(button, i, j);
				organizeWhitePieces(button, i, j);

				chessBoard.add(button, j, i);
			}
		}
	}

	public void moving(ActionEvent actionEvent) throws IOException {
		int col = GridPane.getColumnIndex(currentNode);
		int row = GridPane.getRowIndex(currentNode);

		if(moves == 50) {
			Node node = (Node)actionEvent.getSource();
			globalStage = (Stage)node.getScene().getWindow();

			loadTieMovementScreen();
		}

		if(clicked == 1) {

			int colTarget = GridPane.getColumnIndex(targetNode);
			int rowTarget = GridPane.getRowIndex(targetNode);

			if(board.boardMap[row][col] instanceof Pawn) {
				if(((Pawn) board.boardMap[row][col]).isMovementValid(row, col, rowTarget, colTarget)) {
					moves = 0;
					System.out.println(moves);

					board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

					board.move(row, col, rowTarget, colTarget);
					((Pawn) board.boardMap[row][col]).incrementMoves();

					board.boardMap[rowTarget][colTarget] = board.boardMap[row][col];
					board.boardMap[row][col] = null;

					ImageView sourceImageView = (ImageView) boardButtons[row][col].getGraphic();
					ImageView destinationImageView = (ImageView) boardButtons[rowTarget][colTarget].getGraphic();

					destinationImageView.setImage(sourceImageView.getImage());
					sourceImageView.setImage(null);

					switchPlayer();

					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movements.txt", true));

					if(((Pawn) board.boardMap[rowTarget][colTarget]).ate) {
						colTarget += 97;
						col += 97;
						char columnCharTarget = (char)colTarget;
						char columnCharSource = (char)col;

						switch(rowTarget) {
							case 0 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 -> bufferedWriter.append(String.valueOf(columnCharSource)).append("x").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));

						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					} else {
						colTarget += 97;
						col += 97;
						char columnCharTarget = (char)colTarget;
						char columnCharSource = (char)col;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					}
				}

			} else if(board.boardMap[row][col] instanceof Rook) {

				if(((Rook) board.boardMap[row][col]).isMovementValid(row, col, rowTarget, colTarget)) {
//					moves += 1;
					System.out.println(moves);

					board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

					board.move(row, col, rowTarget, colTarget);

					board.boardMap[rowTarget][colTarget] = board.boardMap[row][col];
					board.boardMap[row][col] = null;

					ImageView sourceImageView = (ImageView) boardButtons[row][col].getGraphic();
					ImageView destinationImageView = (ImageView) boardButtons[rowTarget][colTarget].getGraphic();

					destinationImageView.setImage(sourceImageView.getImage());
					sourceImageView.setImage(null);

					switchPlayer();

					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movements.txt", true));

					if(((Rook) board.boardMap[rowTarget][colTarget]).ate) {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("R" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					} else {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("R").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					}
				}

			} else if(board.boardMap[row][col] instanceof Bishop) {
				if(((Bishop) board.boardMap[row][col]).isMovementValid(row, col, rowTarget, colTarget)) {
//					moves += 1;
					System.out.println(moves);

					board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

					board.move(row, col, rowTarget, colTarget);

					board.boardMap[rowTarget][colTarget] = board.boardMap[row][col];
					board.boardMap[row][col] = null;

					ImageView sourceImageView = (ImageView) boardButtons[row][col].getGraphic();
					ImageView destinationImageView = (ImageView) boardButtons[rowTarget][colTarget].getGraphic();

					destinationImageView.setImage(sourceImageView.getImage());
					sourceImageView.setImage(null);

					switchPlayer();

					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movements.txt", true));
					if(((Bishop) board.boardMap[rowTarget][colTarget]).ate) {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));


							case 1 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));


							case 2 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));


							case 3 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));


							case 4 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));


							case 5 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));


							case 6 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));


							case 7 ->
								bufferedWriter.append("B" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					} else {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));


							case 1 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));


							case 2 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));


							case 3 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));


							case 4 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));


							case 5 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));


							case 6 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));


							case 7 ->
								bufferedWriter.append("B").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					}

				}
			} else if(board.boardMap[row][col] instanceof Queen) {
				if(((Queen) board.boardMap[row][col]).isMovementValid(row, col, rowTarget, colTarget)) {
					System.out.println(moves);

					board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

					board.move(row, col, rowTarget, colTarget);

					board.boardMap[rowTarget][colTarget] = board.boardMap[row][col];
					board.boardMap[row][col] = null;

					ImageView sourceImageView = (ImageView) boardButtons[row][col].getGraphic();
					ImageView destinationImageView = (ImageView) boardButtons[rowTarget][colTarget].getGraphic();

					destinationImageView.setImage(sourceImageView.getImage());
					sourceImageView.setImage(null);

					switchPlayer();

					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movements.txt", true));
					if(((Queen) board.boardMap[rowTarget][colTarget]).ate) {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("Q" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));

						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					} else {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("Q").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					}
				}
			} else if(board.boardMap[row][col] instanceof Knight) {
				if(((Knight) board.boardMap[row][col]).isMovementValid(row, col, rowTarget, colTarget)) {
//					moves += 1;
					System.out.println(moves);

					board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

					board.move(row, col, rowTarget, colTarget);

					board.boardMap[rowTarget][colTarget] = board.boardMap[row][col];
					board.boardMap[row][col] = null;

					ImageView sourceImageView = (ImageView) boardButtons[row][col].getGraphic();
					ImageView destinationImageView = (ImageView) boardButtons[rowTarget][colTarget].getGraphic();

					destinationImageView.setImage(sourceImageView.getImage());
					sourceImageView.setImage(null);

					switchPlayer();

					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movements.txt", true));
					if(((Knight) board.boardMap[rowTarget][colTarget]).ate) {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("N" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					} else {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("N").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					}
				}
			} else if(board.boardMap[row][col] instanceof King) {
				if(((King) board.boardMap[row][col]).isMovementValid(row, col, rowTarget, colTarget)) {
//					moves += 1;
					System.out.println(moves);

					board.clearPossiblePath(board.boardMap[GridPane.getRowIndex(currentNode)][GridPane.getColumnIndex(currentNode)], GridPane.getRowIndex(currentNode), GridPane.getColumnIndex(currentNode));

					board.move(row, col, rowTarget, colTarget);

					board.boardMap[rowTarget][colTarget] = board.boardMap[row][col];
					board.boardMap[row][col] = null;

					ImageView sourceImageView = (ImageView) boardButtons[row][col].getGraphic();
					ImageView destinationImageView = (ImageView) boardButtons[rowTarget][colTarget].getGraphic();

					destinationImageView.setImage(sourceImageView.getImage());
					sourceImageView.setImage(null);

					switchPlayer();

					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("movements.txt", true));
					if(((King) board.boardMap[rowTarget][colTarget]).ate) {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("K" + "x").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					} else {
						colTarget += 97;
						char columnCharTarget = (char)colTarget;

						switch(rowTarget) {
							case 0 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('8'));

							case 1 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('7'));

							case 2 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('6'));

							case 3 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('5'));

							case 4 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('4'));

							case 5 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('3'));

							case 6 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('2'));

							case 7 ->
								bufferedWriter.append("K").append(String.valueOf(columnCharTarget)).append(String.valueOf('1'));
						}

						bufferedWriter.newLine();
						bufferedWriter.close();
					}
				}
			}
		}
	}

	public void initialize() {
		fillChessBoard(chessBoard);
		gameTitle.requestFocus();
	}

	@FXML
	public void onSurrenderButtonClick(ActionEvent actionEvent) throws IOException {
		Node node = (Node)actionEvent.getSource();
		globalStage = (Stage)node.getScene().getWindow();

		loadSurrenderScreen();

	}

	@FXML
	public void onTieButtonClick(ActionEvent actionEvent) {
		Node node = (Node)actionEvent.getSource();
		globalStage = (Stage)node.getScene().getWindow();

		loadTieScreen();
	}

	@FXML
	public void onHelpButtonClick(ActionEvent actionEvent) {
		loadHelpScreen();
	}
}