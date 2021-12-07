package com.example.chessgame.controllers;

import com.example.chessgame.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.chessgame.AppScreens.*;


public class GameLobbyController {
	@FXML
	private Label title;

	@FXML
	private TextField player1;

	@FXML
	private TextField player2;

	@FXML
	private Button selectWhites;

	@FXML
	private Button selectBlacks;

	@FXML
	private Button startButton;

	@FXML
	private Button backButton;

	static Player playerOne = new Player();
	static Player playerTwo = new Player();

	public void initialize() {
		backButton.requestFocus();

		player1.setText("Player 1");
		player2.setText("Player 2");
	}


	@FXML
	protected void onNameSelected() {
			playerOne.setName(player1.getText());
			playerTwo.setName(player2.getText());
	}


	@FXML
	protected void onWhitePieceSelected(ActionEvent actionEvent) throws IOException {
		startButton.disableProperty().set(false);

		playerOne.setPieceColor("WHITES");
		playerTwo.setPieceColor("BLACKS");

		selectWhites.setText("Player 1");
		selectBlacks.setText("Player 2");
		selectWhites.disableProperty().set(true);
		selectBlacks.disableProperty().set(true);

		player2.disableProperty().set(false);

	}

	@FXML
	protected void onBlackPieceSelected(ActionEvent actionEvent) throws IOException {
		startButton.disableProperty().set(false);

		playerOne.setPieceColor("BLACKS");
		playerTwo.setPieceColor("WHITES");

		selectWhites.setText("Player 2");
		selectBlacks.setText("Player 1");
		selectWhites.disableProperty().set(true);
		selectBlacks.disableProperty().set(true);

		player2.disableProperty().set(false);

	}

	@FXML
	protected void onStartButtonClick(ActionEvent actionEvent) {
		loadScene(getStageFromAction(actionEvent), "views/chess-board-view.fxml", "Game started. Good Luck!");
	}

	@FXML
	protected void onExitButtonClick(ActionEvent actionEvent) throws IOException {
		loadScene(getStageFromAction(actionEvent), "views/lobby-view.fxml", "Lobby");
	}

}
