package com.example.zoologico.models;

import com.example.zoologico.Zoologico;
import com.example.zoologico.enums.CustomerCategory;
import com.example.zoologico.enums.PlanCategory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.example.zoologico.Zoologico.invoiceList;

public class SalesDepartment {

    public static Map<String, Float> discounts = new HashMap<>() {{
        put("OCASIONAL", 0.0f);
        put("FRECUENTE", 0.20f);
        put("ABONADO", 0.30f);
    }};

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

    public static String salePlan(
            Customer customer,
            Plans plan,
            int quantity,
            float totalValueSale,
            float totalDiscount
    ) {
        String id = String.valueOf(invoiceList.size() + 1);
        LocalDate date = LocalDate.now();
        SalesInvoice newInvoice = new SalesInvoice(id, date, customer, plan, quantity, totalValueSale, totalDiscount);
        invoiceList.add(newInvoice);
        return "La Factura con ID " + id + " se ha Generado Correctamente!";
    }

}
