package com.example.chessgame.controllers;

import com.example.chessgame.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.chessgame.AppScreens.*;

import java.io.IOException;


public class LobbyController {
	@FXML
	protected void onGuideButtonClick(ActionEvent actionEvent) throws IOException {
		loadScene(getStageFromAction(actionEvent), "views/guide-view.fxml", "Chess Guide");
	}

	@FXML
	protected void onPlayButtonClick(ActionEvent actionEvent) throws IOException {
		loadScene(getStageFromAction(actionEvent), "views/players-view.fxml", "Game Lobby");

	}

	@FXML
	protected void onExitButtonClick(ActionEvent actionEvent) throws IOException {
		closeApplication(actionEvent);
	}

}
