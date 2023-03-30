package com.example.zoologico.data;

import com.example.zoologico.enums.JobTitle;
import com.example.zoologico.models.AdoptionAnimal;
import com.example.zoologico.models.DomesticAnimal;
import com.example.zoologico.models.Employee;
import com.example.zoologico.models.WildAnimal;

import java.time.LocalDate;

import static com.example.zoologico.Zoologico.*;

public class SeedData {

    public SeedData() {
        addUsersData();
        addWildAnimalData();
        addDomesticAnimal();
        addAdoptionAnimal();
    }

    public void addUsersData(){
        Employee employee1 = new Employee("28994397", "Roberto Perez", "admin@google.com", "123456", 5500000, JobTitle.ADMINISTRADOR);
        Employee employee2 = new Employee("43365923", "Liliana Cuartas", "liliana@google.com", "123456", 3500000, JobTitle.VETERINARIO);
        Employee employee3 = new Employee("7548072", "Coco Rodríguez", "coco@google.com", "123456", 2000000, JobTitle.CAJERO);
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(employee3);
    }

    public void addWildAnimalData(){
        WildAnimal wildAnimal1 = new WildAnimal("1", "panthera leo", "Leon", LocalDate.of(2013, 3, 21), "5", "sabana africana", "1");
        WildAnimal wildAnimal2 = new WildAnimal("2", "giraffa camelopardalis", "Jirafa", LocalDate.of(2014, 3, 21), "2", "sabana africana", "4");
        WildAnimal wildAnimal3 = new WildAnimal("3", "hippopotamus amphibius", "Hipopótamo", LocalDate.of(2015, 3, 21), "5", "ríos sabana africana", "1");
        inventoryWildAnimal.add(wildAnimal1);
        inventoryWildAnimal.add(wildAnimal2);
        inventoryWildAnimal.add(wildAnimal3);
    }

    public void addDomesticAnimal(){
        DomesticAnimal domesticAnimal1 = new DomesticAnimal("1", "bos taurus", "Vaca", LocalDate.of(2015, 3, 21), "Producción de leche", true);
        DomesticAnimal domesticAnimal2 = new DomesticAnimal("2", "sus scrofa domestica", "Cerdo", LocalDate.of(2018, 3, 21), "Producción de carne o de compañia", false);
        DomesticAnimal domesticAnimal3 = new DomesticAnimal("3", "gallus gallus domestica", "Gallina", LocalDate.of(2019, 3, 21), "Producción de carne y huevo", true);
        inventoryDomesticAnimal.add(domesticAnimal1);
        inventoryDomesticAnimal.add(domesticAnimal2);
        inventoryDomesticAnimal.add(domesticAnimal3);
    }

    public void addAdoptionAnimal(){
        AdoptionAnimal adoptionAnimal1 = new AdoptionAnimal("1", "canis familiaris", "perro",  LocalDate.of(2015, 3, 21), "coco", true, true);
        AdoptionAnimal adoptionAnimal2 = new AdoptionAnimal("2", "canis familiaris", "perro",  LocalDate.of(2014, 3, 21), "max", true, false);
        AdoptionAnimal adoptionAnimal3 = new AdoptionAnimal("3", "canis familiaris", "gato",  LocalDate.of(2022, 3, 21), "niña", false, false);
        inventoryAdoptionAnimal.add(adoptionAnimal1);
        inventoryAdoptionAnimal.add(adoptionAnimal2);
        inventoryAdoptionAnimal.add(adoptionAnimal3);
    }

}
