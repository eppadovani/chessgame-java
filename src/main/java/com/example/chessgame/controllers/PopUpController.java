package com.example.chessgame.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

import static com.example.chessgame.AppScreens.*;

public class PopUpController {
	@FXML
	private Label popUpTitle;

	@FXML
	private Label popUpMessage;

	String messageText, titlePiece;


	public PopUpController(String message, String title) {
		messageText = message;
		titlePiece = title;
	}

	public void initialize() {
		popUpTitle.setText(titlePiece);
		popUpMessage.setText(messageText);
		popUpMessage.setWrapText(true);
		popUpMessage.setTextAlignment(TextAlignment.JUSTIFY);
	}
}