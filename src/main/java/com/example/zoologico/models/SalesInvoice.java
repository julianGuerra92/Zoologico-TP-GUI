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
    private float totalValueSale, totalDiscount, totalValueWithDiscount;

    public SalesInvoice() {
    }

    public SalesInvoice(
            String id,
            LocalDate date,
            Customer customer,
            Plans plan,
            int quantity,
            float totalValueSale,
            float totalDiscount
    ) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.plan = plan;
        this.quantity = quantity;
        this.totalValueSale = totalValueSale;
        this.totalDiscount = totalDiscount;
        totalValueWithDiscount = totalValueSale - totalDiscount;
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

    public void setTotalValueSale(float totalValueSale) {
        this.totalValueSale = totalValueSale;
    }

    public void setTotalDiscount(float totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public float getTotalValueWithDiscount() {
        return totalValueWithDiscount;
    }

    public void setTotalValueWithDiscount(float totalValueWithDiscount) {
        this.totalValueWithDiscount = totalValueWithDiscount;
    }
}
