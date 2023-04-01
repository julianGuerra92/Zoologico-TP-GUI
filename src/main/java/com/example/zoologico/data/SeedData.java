package com.example.zoologico.data;

import com.example.zoologico.enums.CustomerCategory;
import com.example.zoologico.enums.JobTitle;
import com.example.zoologico.enums.PlanCategory;
import com.example.zoologico.models.*;

import java.time.LocalDate;
import java.util.List;

import static com.example.zoologico.Zoologico.*;

public class SeedData {

    public SeedData() {
        addEmployees();
        addWildAnimalData();
        addDomesticAnimal();
        addAdoptionAnimal();
        addPlans();
        addCustomers();
        addSalesInvoice();
    }

    public void addEmployees() {
        Employee employee1 = new Employee("28994397", "Roberto Perez", "admin@google.com", "123456", 5500000, JobTitle.ADMINISTRADOR);
        Employee employee2 = new Employee("43365923", "Liliana Cuartas", "liliana@google.com", "123456", 3500000, JobTitle.VETERINARIO);
        Employee employee3 = new Employee("7548072", "Coco Rodríguez", "coco@google.com", "123456", 2000000, JobTitle.CAJERO);
        employeesList.addAll(List.of(new Employee[]{employee1, employee2, employee3}));
    }

    public void addWildAnimalData() {
        WildAnimal wildAnimal1 = new WildAnimal("1", "panthera leo", "Leon", LocalDate.of(2013, 3, 21), "5", "sabana africana", "1");
        WildAnimal wildAnimal2 = new WildAnimal("2", "giraffa camelopardalis", "Jirafa", LocalDate.of(2014, 3, 21), "2", "sabana africana", "4");
        WildAnimal wildAnimal3 = new WildAnimal("3", "hippopotamus amphibius", "Hipopótamo", LocalDate.of(2015, 3, 21), "5", "ríos sabana africana", "1");
        inventoryWildAnimal.addAll(List.of(new WildAnimal[]{wildAnimal1, wildAnimal2, wildAnimal3}));
    }

    public void addDomesticAnimal() {
        DomesticAnimal domesticAnimal1 = new DomesticAnimal("1", "bos taurus", "Vaca", LocalDate.of(2015, 3, 21), "Producción de leche", true);
        DomesticAnimal domesticAnimal2 = new DomesticAnimal("2", "sus scrofa domestica", "Cerdo", LocalDate.of(2018, 3, 21), "Producción de carne o de compañia", false);
        DomesticAnimal domesticAnimal3 = new DomesticAnimal("3", "gallus gallus domestica", "Gallina", LocalDate.of(2019, 3, 21), "Producción de carne y huevo", true);
        inventoryDomesticAnimal.addAll(List.of(new DomesticAnimal[]{domesticAnimal1, domesticAnimal2, domesticAnimal3}));
    }

    public void addAdoptionAnimal() {
        AdoptionAnimal adoptionAnimal1 = new AdoptionAnimal("1", "canis familiaris", "perro", LocalDate.of(2015, 3, 21), "coco", true, true);
        AdoptionAnimal adoptionAnimal2 = new AdoptionAnimal("2", "canis familiaris", "perro", LocalDate.of(2014, 3, 21), "max", true, false);
        AdoptionAnimal adoptionAnimal3 = new AdoptionAnimal("3", "canis familiaris", "gato", LocalDate.of(2022, 3, 21), "niña", false, false);
        inventoryAdoptionAnimal.addAll(List.of(new AdoptionAnimal[]{adoptionAnimal1, adoptionAnimal2, adoptionAnimal3}));
    }

    public void addPlans() {
        Plans plan1 = new Plans("Navegando con Caimanes", PlanCategory.GENERAL_TODO_INCLUIDO, "", 15, 55000, true);
        Plans plan2 = new Plans("Navegando con Delfines", PlanCategory.GENERAL_NINIO_ADULTO, "", 10, 35000, false);
        Plans plan3 = new Plans("Viajando entre Familia de Felinos", PlanCategory.GENERAL_TODO_INCLUIDO, "", 15, 85000, true);
        Plans plan4 = new Plans("Mundo Acuático", PlanCategory.GENERAL_NINIO_ADULTO, "", 20, 30000, false);
        Plans plan5 = new Plans("Lluvia de reptiles", PlanCategory.GENERAL_NINIO_ADULTO, "", 10, 20000, false);
        Plans plan6 = new Plans("Compañero Ideal", PlanCategory.TOUR_GRANJA_TODO_INCLUIDO, "", 50, 65000, true);
        Plans plan7 = new Plans("Entrada General al Zoológico", PlanCategory.GENERAL_NINIO_ADULTO, "", 300, 15000, false);
        Plans plan8 = new Plans("Abono Mensual Cliente Preferencial", PlanCategory.ABONO_MENSUAL, "", 20, 30000, false);
        plansList.addAll(List.of(new Plans[]{plan1, plan2, plan3, plan4, plan5, plan6, plan7, plan8}));
    }

    public void addCustomers() {
        Customer customer1 = new Customer("Margarita Arboleda", "55860923", LocalDate.of(1995, 11, 24), CustomerCategory.FRECUENTE);
        Customer customer2 = new Customer("Julio Gutierrez", "28993451", LocalDate.of(1965, 7, 10), CustomerCategory.OCASIONAL);
        Customer customer3 = new Customer("Luisa Roldan", "1095867541", LocalDate.of(1985, 2, 2), CustomerCategory.ABONADO);
        customerList.addAll(List.of(new Customer[]{customer1, customer2, customer3}));
    }

    public  void addSalesInvoice(){
        SalesInvoice invoice1 = new SalesInvoice("1", LocalDate.of(2023, 3, 20), customerList.get(0), plansList.get(0), 3, 120000, 24000);
        SalesInvoice invoice2 = new SalesInvoice("2", LocalDate.of(2023, 3, 20), customerList.get(0), plansList.get(3), 2, 90000, 18000);
        SalesInvoice invoice3 = new SalesInvoice("3", LocalDate.of(2023, 3, 20), customerList.get(1), plansList.get(2), 2, 150000, 45000);
        SalesInvoice invoice4 = new SalesInvoice("4", LocalDate.of(2023, 3, 20), customerList.get(1), plansList.get(1), 5, 45000, 0);
        SalesInvoice invoice5 = new SalesInvoice("5", LocalDate.of(2023, 3, 28), customerList.get(0), plansList.get(4), 3, 95000, 28500);
        SalesInvoice invoice6 = new SalesInvoice("6", LocalDate.of(2023, 3, 28), customerList.get(0), plansList.get(5), 2, 110000, 0);
        SalesInvoice invoice7 = new SalesInvoice("7", LocalDate.of(2023, 3, 28), customerList.get(1), plansList.get(6), 10, 250000, 50000);
        SalesInvoice invoice8 = new SalesInvoice("8", LocalDate.of(2023, 3, 30), customerList.get(2), plansList.get(7), 1, 30000, 0);
        invoiceList.addAll(List.of(new SalesInvoice[]{invoice1, invoice2, invoice3, invoice4, invoice5, invoice6, invoice7, invoice8}));
    }

}
