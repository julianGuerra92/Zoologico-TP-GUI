package com.example.zoologico.controllers;

import com.example.zoologico.models.AdoptionAnimal;
import com.example.zoologico.models.DomesticAnimal;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.zoologico.Zoologico.*;

public class AnimalAdoptionController implements Initializable {
    @FXML
    private BorderPane scenePane;
    @FXML
    private TableView<AdoptionAnimal> adoptionAnimalTable;
    @FXML
    private TableColumn<AdoptionAnimal, String> colId, colName;
    @FXML
    private TableColumn<AdoptionAnimal, Boolean> colSterilized, colAvailable, colAdopted;
    @FXML
    private ChoiceBox fieldSterilized, fieldAvailable, fieldAdopted;
    @FXML
    private Label fieldName;
    private Boolean[] choiceBoxItem = {true, false};
    private AdoptionAnimal clickedAnimal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<AdoptionAnimal, String>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<AdoptionAnimal, String>("name"));
        colSterilized.setCellValueFactory(new PropertyValueFactory<AdoptionAnimal, Boolean>("sterilized"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<AdoptionAnimal, Boolean>("available"));
        colAdopted.setCellValueFactory(new PropertyValueFactory<AdoptionAnimal, Boolean>("adopted"));
        fieldSterilized.getItems().addAll(choiceBoxItem);
        fieldAvailable.getItems().addAll(choiceBoxItem);
        fieldAdopted.getItems().addAll(choiceBoxItem);
        setupTable();
    }

    public void setupTable() {
        adoptionAnimalTable.getItems().addAll(inventoryAdoptionAnimal);
    }

    @FXML
    public void rowClicked(MouseEvent event) {
        clickedAnimal = adoptionAnimalTable.getSelectionModel().getSelectedItem();
        fieldSterilized.setValue(clickedAnimal.isSterilized());
        fieldAvailable.setValue(clickedAnimal.isAvailable());
        fieldAdopted.setValue(clickedAnimal.isAdopted());
        fieldName.setText(clickedAnimal.getName());
    }

    @FXML
    public void saveChange(){
        clickedAnimal.setSterilized((Boolean) fieldSterilized.getValue());
        clickedAnimal.setAvailable((Boolean) fieldAvailable.getValue());
        clickedAnimal.setAdopted((Boolean) fieldAdopted.getValue());
        adoptionAnimalTable.refresh();
    }

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

}
