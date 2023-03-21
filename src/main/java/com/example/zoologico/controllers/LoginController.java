package com.example.zoologico.controllers;

import com.example.zoologico.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.zoologico.Zoologico.employeesList;

public class LoginController {
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldPassword;
    @FXML
    private VBox scenePane;

    public boolean validateCredential(String email, String password) {
        for (Employee employee : employeesList) {
            if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void switchToInitialWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/zoologico/initial-view.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/zoologico/styles.css").toExternalForm());
        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(scene);
        stage.toFront();
        stage.show();
    }

    public void logIn(ActionEvent actionEvent) throws IOException {
        String email = fieldEmail.getText();
        String password = fieldPassword.getText();
        if (validateCredential(email, password)) {
            switchToInitialWindow();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Correo o Contraseña Incorrecta");
            alert.showAndWait();
        }
    }

}