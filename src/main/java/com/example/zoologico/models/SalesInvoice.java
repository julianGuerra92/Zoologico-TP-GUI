package com.example.zoologico.models;

import com.example.zoologico.enums.CustomerCategory;
import com.example.zoologico.enums.PlanCategory;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesInvoice {
    private String id;
    private LocalDate date;
    private Customer customer;
    private Plans plan;
    private int quantity;
    private float totalValueSale;
    private float totalDiscount = 0f;

    public SalesInvoice() {
    }

    public SalesInvoice(String id, LocalDate date, Customer customer, Plans plan, int quantity) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.plan = plan;
        this.quantity = quantity;
        calculateTotal();
        calculateDiscount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Plans getPlan() {
        return plan;
    }

    public void setPlan(Plans plan) {
        this.plan = plan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalValueSale() {
        return totalValueSale;
    }

    public float getTotalDiscount() {
        return totalDiscount;
    }

    public void calculateTotal() {
        totalValueSale = plan.getPrice() * quantity;
    }

    public void calculateDiscount() {
        if (customer.getCategory().equals(CustomerCategory.ABONADO) && !plan.getCategory().equals(PlanCategory.ABONO_MENSUAL)) {
            totalDiscount = totalValueSale * 0.30f;
        }
        if (customer.getCategory().equals(CustomerCategory.FRECUENTE)) {
            totalDiscount = totalValueSale * 0.20f;
        }
    }

}
