module com.example.chessgame {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.chessgame to javafx.fxml;
	exports com.example.chessgame;
	opens com.example.chessgame.models to javafx.fxml;
	exports com.example.chessgame.models;
	opens com.example.chessgame.controllers to javafx.fxml;
	exports com.example.chessgame.controllers;
}