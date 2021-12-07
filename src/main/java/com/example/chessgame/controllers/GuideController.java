package com.example.chessgame.controllers;

import com.example.chessgame.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static com.example.chessgame.AppScreens.*;


import java.io.IOException;

public class GuideController {
	private double DEFAULT_POPUP_WIDTH = 404;
	private double DEFAULT_POPUP_HEIGHT = 450;

	protected void lobbyView(ActionEvent actionEvent) throws IOException {
		Node node = (Node)actionEvent.getSource();
		Stage currentStage = (Stage)node.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/lobby-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		currentStage.setTitle("Game lobby");
		currentStage.setScene(scene);
		currentStage.setResizable(false);
		currentStage.show();
	}

	@FXML
	protected void onKingButtonClick() {
		loadPopUp("King information", "The king (♔, ♚) is the most important piece in the game of chess. The king can move one square in any direction (orthogonally or diagonally), and also has a special move known as \"castling\". If a player's king is threatened with capture, it is said to be in check, and the player must remove the threat of capture on the next move. If this cannot be done, the king is said to be in checkmate, resulting in a loss for that player. Players cannot make any move that places their own king in check. Despite this, the king can become a strong offensive piece in the endgame, or rarely in the middlegame.", "KING", DEFAULT_POPUP_WIDTH, DEFAULT_POPUP_HEIGHT);
	}

	@FXML
	protected void onKnightButtonClick() {
		loadPopUp("Knight information", "Compared to other chess pieces, the knight's movement is unique: it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). This way, a knight can have a maximum of 8 moves. While moving, the knight can jump over pieces to reach its destination. Knights capture in the same way, replacing the enemy piece on the square and removing it from the board. Knights and pawns are the only pieces that can be moved in the initial position.", "KNIGHT", DEFAULT_POPUP_WIDTH, DEFAULT_POPUP_HEIGHT);
	}

	@FXML
	protected void onQueenButtonClick() {
		loadPopUp("Queen information", "The queen (♕, ♛) is the most powerful piece in the game of chess, able to move any number of squares vertically, horizontally or diagonally, combining the power of the rook and bishop. Each player starts the game with one queen, placed in the middle of the first rank next to the king. Because the queen is the strongest piece, a pawn is promoted to a queen in the vast majority of cases.", "QUEEN", DEFAULT_POPUP_WIDTH, DEFAULT_POPUP_HEIGHT);
	}

	@FXML
	protected void onBishopButtonClick() {
		loadPopUp("Bishop information", "The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Bishops, like all other pieces except the knight, cannot jump over other pieces. A bishop captures by occupying the square on which an enemy piece sits.", "BISHOP", DEFAULT_POPUP_WIDTH, DEFAULT_POPUP_HEIGHT);
	}

	@FXML
	protected void onRookButtonClick() {
		loadPopUp("Rook information", "The white rooks start on squares a1 and h1, while the black rooks start on a8 and h8. The rook moves horizontally or vertically, through any number of unoccupied squares (see diagram). The rook cannot jump over pieces. As with captures by other pieces, the rook captures by occupying the square on which the enemy piece sits. The rook also participates, with the king, in a special move called castling.", "ROOK", DEFAULT_POPUP_WIDTH, DEFAULT_POPUP_HEIGHT);
	}

	@FXML
	protected void onPawnButtonClick(ActionEvent actionEvent) {
		loadPopUp("Pawn information", "Unlike the other pieces, pawns cannot move backwards. Normally a pawn moves by advancing a single square, but the first time a pawn moves, it has the option of advancing two squares. Pawns may not use the initial two-square advance to jump over an occupied square, or to capture. Any piece immediately in front of a pawn, friend or foe, blocks its advance. In the second diagram, the pawn on c4 can move to c5; the pawn on e2 can move to either e3 or e4.", "PAWN", DEFAULT_POPUP_WIDTH, DEFAULT_POPUP_HEIGHT);
	}

	@FXML
	protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
		lobbyView(actionEvent);
	}
}
