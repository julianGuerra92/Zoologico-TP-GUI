package com.example.zoologico.controllers;

import com.example.zoologico.models.DomesticAnimal;
import com.example.zoologico.models.WildAnimal;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.zoologico.Zoologico.inventoryDomesticAnimal;
import static com.example.zoologico.Zoologico.inventoryWildAnimal;

public class AnimalZooController implements Initializable {

    @FXML
    private TableView<WildAnimal> wildAnimalTable;
    @FXML
    private TableView<DomesticAnimal> domesticAnimalTable;
    @FXML
    private TableColumn<WildAnimal, String> colIdW, colNameW, colDangerLevelW, colCompatibilityW;
    @FXML
    private TableColumn<WildAnimal, Long> colAgeW;
    @FXML
    private TableColumn<DomesticAnimal, String> colIdD, colNameD, colUseDomesticD;
    @FXML
    private TableColumn<DomesticAnimal, Long> colAgeD;
    @FXML
    private TableColumn<DomesticAnimal, Boolean> colCompatibilityD;
    @FXML
    private BorderPane scenePane;
    @FXML
    private TextField fieldWID, fieldWScientificName, fieldWCommonName, fieldWNaturalHabitat;
    @FXML
    private TextField fieldDID, fieldDScientificName, fieldDCommonName, fieldDNaturalHabitat, fieldDomesticUse;
    @FXML
    private DatePicker datePickerW, datePickerD;
    @FXML
    private ChoiceBox fieldWDangerLevel, fieldWCompatibility, fieldDCompatibility;
    private ObservableList<WildAnimal> wildAnimals;
    private ObservableList<DomesticAnimal> domesticAnimals;
    private String[] levelChoice = {"1", "2", "3", "4", "5"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colIdW.setCellValueFactory(new PropertyValueFactory<WildAnimal, String>("id"));
        colNameW.setCellValueFactory(new PropertyValueFactory<WildAnimal, String>("commonName"));
        colAgeW.setCellValueFactory(new PropertyValueFactory<WildAnimal, Long>("age"));
        colDangerLevelW.setCellValueFactory(new PropertyValueFactory<WildAnimal, String>("dangerLevel"));
        colCompatibilityW.setCellValueFactory(new PropertyValueFactory<WildAnimal, String>("compatibilityLevel"));
        colIdD.setCellValueFactory(new PropertyValueFactory<DomesticAnimal, String>("id"));
        colNameD.setCellValueFactory(new PropertyValueFactory<DomesticAnimal, String>("commonName"));
        colAgeD.setCellValueFactory(new PropertyValueFactory<DomesticAnimal, Long>("age"));
        colUseDomesticD.setCellValueFactory(new PropertyValueFactory<DomesticAnimal, String>("domesticUso"));
        colCompatibilityD.setCellValueFactory(new PropertyValueFactory<DomesticAnimal, Boolean>("compatibilityWithChildren"));
        fieldWDangerLevel.getItems().addAll(levelChoice);
        fieldWCompatibility.getItems().addAll(levelChoice);
        fieldDCompatibility.getItems().addAll(levelChoice);
        setupTable();
    }

    private void setupTable() {
        wildAnimalTable.getItems().addAll(inventoryWildAnimal);
        domesticAnimalTable.getItems().addAll(inventoryDomesticAnimal);
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

    public void saveWildAnimal(ActionEvent actionEvent) {
        WildAnimal animal = new WildAnimal(
                fieldWID.getText(),
                fieldWScientificName.getText(),
                fieldWCommonName.getText(),
                datePickerW.getValue(),
                (String) fieldWDangerLevel.getValue(),
                fieldWNaturalHabitat.getText(),
                (String) fieldWCompatibility.getValue()
        );
        inventoryWildAnimal.add(animal);
        wildAnimals = wildAnimalTable.getItems();
        wildAnimals.add(animal);
        cleanFields();
        wildAnimalTable.setItems(wildAnimals);
    }

    public void cleanFields() {
        fieldWID.setText("");
        fieldWScientificName.setText("");
        fieldWCommonName.setText("");
        datePickerW.setValue(null);
        fieldWDangerLevel.setValue("");
        fieldWNaturalHabitat.setText("");
        fieldWCompatibility.setValue("");
    }

}
