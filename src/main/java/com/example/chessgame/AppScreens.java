package com.example.chessgame;

import com.example.chessgame.controllers.PopUpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppScreens {
	private static double DEFAULT_WIDTH = 1280;
	private static double DEFAULT_HEIGHT = 720;

	public static Stage getStageFromAction(ActionEvent actionEvent){
		return (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
	}

	public static void loadScene(Stage stage, String path, String stageTitle){
		try{
			FXMLLoader root = new FXMLLoader(GameApplication.class.getResource(path));
			Scene scene = new Scene(root.load(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
			stage.setTitle(stageTitle);
			stage.setScene(scene);
			stage.setResizable(false);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadScene(Stage stage, String path, String stageTitle, double width, double height) {
		try {
			FXMLLoader root = new FXMLLoader(GameApplication.class.getResource(path));
			Scene scene = new Scene(root.load(), width, height);
			stage.setTitle(stageTitle);
			stage.setResizable(false);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadPopUp(String stageTitle, String message, String title, double width, double height) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/pieces-popup-view.fxml"));
			fxmlLoader.setController(new PopUpController(message, title));
			Stage popUpStage = new Stage();
			Scene popUpScene = new Scene(fxmlLoader.load(), 404, 450);
			popUpStage.setTitle(stageTitle);
			popUpStage.setScene(popUpScene);
			popUpStage.setResizable(false);

			Image appLogo = new Image(GameApplication.class.getResourceAsStream("images/appIcon.png"));
			popUpStage.getIcons().add(appLogo);

			popUpStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadSurrenderScreen() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/popup-view.fxml"));
			Stage popUpStage = new Stage();
			Scene popUpScene = new Scene(fxmlLoader.load(), 323, 190);
			popUpStage.initModality(Modality.APPLICATION_MODAL);
			popUpStage.initStyle(StageStyle.UNDECORATED);
			popUpStage.setTitle("Surrender");
			popUpStage.setScene(popUpScene);
			popUpStage.setResizable(false);

			Image appLogo = new Image(GameApplication.class.getResourceAsStream("images/appIcon.png"));
			popUpStage.getIcons().add(appLogo);

			popUpStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadTieScreen() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/popup-view.fxml"));
			Stage popUpStage = new Stage();
			Scene popUpScene = new Scene(fxmlLoader.load(), 323, 190);
			popUpStage.initModality(Modality.APPLICATION_MODAL);
			popUpStage.initStyle(StageStyle.UNDECORATED);
			popUpStage.setTitle("Tie proposal");
			popUpStage.setScene(popUpScene);
			popUpStage.setResizable(false);

			Image appLogo = new Image(GameApplication.class.getResourceAsStream("images/appIcon.png"));
			popUpStage.getIcons().add(appLogo);

			popUpStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadHelpScreen() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/help-view.fxml"));
			Stage helpStage = new Stage();
			Scene helpScene = new Scene(fxmlLoader.load(), 1280, 720);
			helpStage.initModality(Modality.APPLICATION_MODAL);
			helpStage.initStyle(StageStyle.UNDECORATED);
			helpStage.setTitle("Cheat sheet");
			helpStage.setScene(helpScene);
			helpStage.setResizable(false);

			Image appLogo = new Image(GameApplication.class.getResourceAsStream("images/appIcon.png"));
			helpStage.getIcons().add(appLogo);

			helpStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadTieMovementScreen() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("views/movement-tie-view.fxml"));
			Stage popUpStage = new Stage();
			Scene popUpScene = new Scene(fxmlLoader.load(), 323, 190);
			popUpStage.initModality(Modality.APPLICATION_MODAL);
			popUpStage.initStyle(StageStyle.UNDECORATED);
			popUpStage.setTitle("Tie proposal");
			popUpStage.setScene(popUpScene);
			popUpStage.setResizable(false);

			Image appLogo = new Image(GameApplication.class.getResourceAsStream("images/appIcon.png"));
			popUpStage.getIcons().add(appLogo);

			popUpStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void closeApplication(ActionEvent actionEvent) throws IOException {
		Node node = (Node)actionEvent.getSource();
		Stage currentStage = (Stage)node.getScene().getWindow();
		currentStage.close();
	}
}