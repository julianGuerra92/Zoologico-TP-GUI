package com.example.zoologico.controllers;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class InitialController {

    @FXML
    private BorderPane scenePane;

    public void showWindow(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/com/example/zoologico/styles.css").toExternalForm());
        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(scene);
        stage.toFront();
        stage.toFront();
        stage.show();
    }

    public void onChangeWindow(ActionEvent actionEvent) throws IOException {
        String windowId = actionEvent.getSource().toString();
        if (windowId.contains("mainPanel")) showWindow("/com/example/zoologico/initial-view.fxml");
        if (windowId.contains("animalZoo")) showWindow("/com/example/zoologico/animal-zoo-view.fxml");
        if (windowId.contains("animalAdoption")) showWindow("/com/example/zoologico/animal-adoption-view.fxml");
        if (windowId.contains("sales")) showWindow("/com/example/zoologico/sales-view.fxml");
        if (windowId.contains("registerClients")) showWindow("/com/example/zoologico/register-clients-view.fxml");
        if (windowId.contains("registerEmployee")) showWindow("/com/example/zoologico/register-employee-view.fxml");
        if (windowId.contains("closeSession")) showWindow("/com/example/zoologico/login-view.fxml");
    }

    public void exitAplication(ActionEvent actionEvent) {
        Stage stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }

    public void printReport(ActionEvent actionEvent) throws DocumentException, IOException {
        PdfController.generatePdf();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Informe de Gestión Generado de Manera Exitosa!");
        alert.showAndWait();
    }
}
