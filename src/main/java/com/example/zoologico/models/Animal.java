package com.example.zoologico.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author  Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa la estructura y carcaterística general de los animales pertenecientes
 * al zoológico. De esta se extenderá las demás clases de los tipos específicos de animales en el zoológico.
 */
public class Animal {
    private String id, scientificName, commonName;
    private LocalDate birthDate;
    private long age;

    public Animal() {
    }

    public Animal(String id, String scientificName, String commonName, LocalDate birthDate) {
        this.id = id;
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.birthDate = birthDate;
        this.age = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", species='" + commonName + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                '}';
    }

}
