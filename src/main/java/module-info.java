module com.example.zoologico {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zoologico to javafx.fxml;
    exports com.example.zoologico;
    exports com.example.zoologico.controllers;
    opens com.example.zoologico.controllers to javafx.fxml;
    opens com.example.zoologico.models to javafx.base;
}