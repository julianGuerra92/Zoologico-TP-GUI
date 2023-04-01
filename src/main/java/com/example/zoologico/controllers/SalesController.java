package com.example.zoologico.controllers;

import com.example.zoologico.enums.PlanCategory;
import com.example.zoologico.models.Customer;
import com.example.zoologico.models.Plans;
import com.example.zoologico.models.SalesDepartment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static com.example.zoologico.Zoologico.customerList;
import static com.example.zoologico.Zoologico.plansList;

public class SalesController implements Initializable {
    @FXML
    private BorderPane scenePane;
    @FXML
    private TextField fieldID;
    @FXML
    private Label fieldName, fieldCategory, fieldDiscount, fieldCostUnit, fieldTotalDiscount, fieldTotal;
    @FXML
    private ChoiceBox choiceBoxPlans;
    @FXML
    private Spinner<Integer> spinnerQuantity;
    private Customer customer;
    private Plans plan;
    private float discount, totalDiscount = 0, totalCost;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPlans();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);
        valueFactory.setValue(1);
        spinnerQuantity.setValueFactory(valueFactory);
    }

    public void cleanFieldsCustomer() {
        fieldName.setText("");
        fieldCategory.setText("");
        fieldDiscount.setText("");
        fieldCostUnit.setText("");
        fieldTotalDiscount.setText("");
        fieldTotal.setText("");
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

    public void showConfirmationMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.showAndWait();
    }

    public void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }

    public void loadPlans() {
        for (Plans plan : plansList) {
            choiceBoxPlans.getItems().add(plan.getName());
        }
    }

    public void loadPlan(ActionEvent event) {
        for (Plans plan : plansList) {
            if (plan.getName().equals(choiceBoxPlans.getValue())) {
                this.plan = plan;
            }
        }
    }

    public void searchClient(ActionEvent actionEvent) {
        customer = null;
        for (Customer customer : customerList) {
            if (customer.getId().equals(fieldID.getText())) {
                this.customer = customer;
                loadCustomerInformation();
                calculateSaleValue();
            }
        }
        if (customer == null) {
            cleanFieldsCustomer();
            showErrorMessage("No existe un cliente con este ID");
        }
    }

    public void loadCustomerInformation() {
        fieldName.setText(customer.getFullName());
        fieldCategory.setText(String.valueOf(customer.getCategory()));
        for (Map.Entry<String, Float> discount : SalesDepartment.discounts.entrySet()) {
            if (discount.getKey().equals(String.valueOf(customer.getCategory()))) {
                this.discount = discount.getValue();
                fieldDiscount.setText(String.format("%,.1f", this.discount * 100));
            }
        }
    }

    public void calculateSaleValue() {
        if(plan.getCategory() != PlanCategory.ABONO_MENSUAL){
            totalDiscount = (plan.getPrice() * spinnerQuantity.getValue()) * discount;
        }
        totalCost = (plan.getPrice() * spinnerQuantity.getValue()) - totalDiscount;
        fieldCostUnit.setText(String.format("%,.1f", plan.getPrice()));
        fieldTotalDiscount.setText(String.format("%,.1f", totalDiscount));
        fieldTotal.setText(String.format("%,.1f", totalCost));
    }

    public void generateSaleInvoice(){
        String message = SalesDepartment.salePlan(customer, plan, spinnerQuantity.getValue(), totalCost, totalDiscount);
        showConfirmationMessage(message);
        cleanFieldsCustomer();
    }

}
