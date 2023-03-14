package com.example.zoologico.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesInvoice {
    private String id;
    private LocalDate date;
    private Customer customer;
    private ArrayList<Plans> plans;
    private float totalValueSale;

    public SalesInvoice() {
    }

    public SalesInvoice(String id, LocalDate date, Customer customer, ArrayList<Plans> plans) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.plans = plans;
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

    public ArrayList<Plans> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<Plans> plans) {
        this.plans = plans;
    }

    public float getTotalValueSale() {
        return totalValueSale;
    }

    public void calculateTotal(){
        for(Plans plan : plans){
            totalValueSale += (plan.getPrice() * plan.getQuantity());
        }
    }

}
