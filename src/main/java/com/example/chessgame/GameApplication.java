package com.example.chessgame;

import com.example.chessgame.controllers.ChessBoardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameApplication extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/intro-view.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
		stage.setTitle("Introduction");
		stage.setScene(scene);
		stage.setResizable(false);

		Image appLogo = new Image(Objects.requireNonNull(GameApplication.class.getResourceAsStream("images/appIcon.png")));
		stage.getIcons().add(appLogo);

		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}