package com.example.zoologico;

import com.example.zoologico.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Zoologico extends Application {
    public static ArrayList<WildAnimal> inventoryWildAnimal = new ArrayList<WildAnimal>();
    public static ArrayList<DomesticAnimal> inventoryDomesticAnimal = new ArrayList<DomesticAnimal>();
    public static ArrayList<AdoptionAnimal> inventoryAdoptionAnimal = new ArrayList<AdoptionAnimal>();
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();
    public static ArrayList<Plans> plansList = new ArrayList<Plans>();
    public static ArrayList<SalesInvoice> invoiceList = new ArrayList<SalesInvoice>();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Zoologico.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}