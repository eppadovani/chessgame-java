package com.example.chessgame.controllers;

import com.example.chessgame.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

	protected void lobbyView(ActionEvent actionEvent) throws IOException {
		Node node = (Node)actionEvent.getSource();
		Stage currentStage = (Stage)node.getScene().getWindow();

		FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/lobby-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		currentStage.setTitle("Game lobby");
		currentStage.setScene(scene);
		currentStage.setResizable(false);

		Image appLogo = new Image(GameApplication.class.getResourceAsStream("images/appIcon.png"));
		currentStage.getIcons().add(appLogo);

		currentStage.show();
	}

	@FXML
	protected void onStartButtonClick(ActionEvent actionEvent) throws IOException {
		lobbyView(actionEvent);
	}
}