package com.example.zoologico.models;

import com.example.zoologico.enums.CustomerCategory;

import java.time.LocalDate;

/**
 * @author Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa los clientes que serán registrados al momento de realizar venta de servicios
 * en el zoológico.
 */
public class Customer {
    private String fullName;
    private String id;
    private LocalDate birthDate;
    private boolean insideZoo;
    private CustomerCategory category;
    private int visitorCounter;

    public Customer() {
    }

    public Customer(
            String fullName,
            String id,
            LocalDate birthDate,
            CustomerCategory category
    ) {
        this.fullName = fullName;
        this.id = id;
        this.birthDate = birthDate;
        insideZoo = false;
        this.category = category;
        visitorCounter = 0;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isInsideZoo() {
        return insideZoo;
    }

    public void setInsideZoo(boolean insideZoo) {
        this.insideZoo = insideZoo;
    }

    public CustomerCategory getCategory() {
        return category;
    }

    public void setCategory(CustomerCategory category) {
        this.category = category;
    }

    public int getVisitorCounter() {
        return visitorCounter;
    }

    public void setVisitorCounter(int visitorCounter) {
        this.visitorCounter = visitorCounter;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", id='" + id + '\'' +
                ", birthDate=" + birthDate +
                ", insideZoo=" + insideZoo +
                ", category=" + category +
                ", visitorCounter=" + visitorCounter +
                '}';
    }
}
