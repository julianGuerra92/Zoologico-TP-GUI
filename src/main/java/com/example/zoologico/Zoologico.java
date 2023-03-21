package com.example.zoologico;

import com.example.zoologico.enums.JobTitle;
import com.example.zoologico.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Zoologico extends Application {
    public static ArrayList<WildAnimal> inventoryWildAnimal = new ArrayList<WildAnimal>();
    public static ArrayList<DomesticAnimal> inventoryDomesticAnimal = new ArrayList<DomesticAnimal>();
    public static ArrayList<AdoptionAnimal> inventoryAdoptionAnimal = new ArrayList<AdoptionAnimal>();
    public static ArrayList<Customer> customerList = new ArrayList<Customer>();
    public static ArrayList<Plans> plansList = new ArrayList<Plans>();
    public static ArrayList<SalesInvoice> invoiceList = new ArrayList<SalesInvoice>();
    public static LinkedList<Employee> employeesList = new LinkedList<Employee>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Zoologico.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Zoológico ZOODI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Employee administrator = new Employee(
                "1094931275",
                "Julián Rodríguez",
                "julian@google.com",
                "123456",
                5500000,
                JobTitle.ADMINISTRADOR
        );
        employeesList.add(administrator);
        launch();
    }
}

//TODO: Revisar si se requiere definir clases final
//TODO: Revisar generación de javadoc