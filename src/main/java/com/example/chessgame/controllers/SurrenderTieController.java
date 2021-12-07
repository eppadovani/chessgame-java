package com.example.chessgame.controllers;

import com.example.chessgame.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static com.example.chessgame.AppScreens.*;


public class SurrenderTieController {

	@FXML
	public void onYesButtonClick(ActionEvent actionEvent) throws IOException {
		closeApplication(actionEvent);

		FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/intro-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		ChessBoardController.globalStage.setTitle("Intro");
		ChessBoardController.globalStage.setScene(scene);
		ChessBoardController.globalStage.setResizable(false);
		ChessBoardController.globalStage.show();
	}

	@FXML
	protected void onNoButtonClick(ActionEvent actionEvent) throws IOException {
		closeApplication(actionEvent);
	}

	@FXML
	protected void onBackButtonClick(ActionEvent actionEvent) throws IOException {
		closeApplication(actionEvent);
	}

}
