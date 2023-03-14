package com.example.zoologico.models;

import com.example.zoologico.Zoologico;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesDepartment {

    public static String registerNewCustomer(
            String fullName,
            String id,
            LocalDate birthDate,
            CustomerCategory category
    ) {
        Customer newCustomer = new Customer(fullName, id, birthDate, category);
        Zoologico.customerList.add(newCustomer);
        return "El cliente " + fullName + "ha sido creado de manera satisfactoria!";
    }

    public static String registerNewPlan(
            String name,
            PlanCategory category,
            String description,
            int quantity,
            float price,
            boolean allInclusive
    ) {
        Plans newPlan = new Plans(name, category, description, quantity, price, allInclusive);
        Zoologico.plansList.add(newPlan);
        return "El plan " + name + " ha sido creado de manera satisfactoria!";
    }

    public static String salePlans(String id, LocalDate date, Customer customer, ArrayList<Plans> plans){
        SalesInvoice newInvoice = new SalesInvoice(id, date, customer, plans);
        newInvoice.calculateTotal();
        Zoologico.invoiceList.add(newInvoice);
        return "El registro de venta con id " + id + "ha sido generado de manera exitosa!";
    }

}
