package com.example.zoologico.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Aquí se hará la implementación de la interfaz gráfica de usuario :)");
    }
}