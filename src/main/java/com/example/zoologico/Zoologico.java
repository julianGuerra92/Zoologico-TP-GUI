package com.example.zoologico;

import com.example.zoologico.controllers.PdfController;
import com.example.zoologico.data.SeedData;
import com.example.zoologico.models.*;
import com.itextpdf.text.DocumentException;
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

    public static void main(String[] args) throws DocumentException, IOException {
        SeedData seedData = new SeedData();
        PdfController.generatePdf();
        launch();
    }
}

//TODO: Revisar generación de javadoc
//TODO: Agregar la Clase Usuario que herede de empleado y tenga los tributos de correo y password
//TODO: Integrar adecuadamente la funcionalidad para la impresión del documento de ventas.