package com.example.zoologico.models;

import java.time.LocalDate;

/**
 * @author Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa al tipo de animal domestico (vacas, gallinas, patos, etc.), quienes heredan
 * directamente de la clase animal.
 */
public class DomesticAnimal extends Animal {

    private String domesticUso;
    private boolean compatibilityWithChildren;

    public DomesticAnimal() {
    }

    public DomesticAnimal(
            String id,
            String scientificName,
            String species,
            LocalDate birthDate,
            String domesticUso,
            boolean compatibilityWithChildren
    ) {
        super(id, scientificName, species, birthDate);
        this.domesticUso = domesticUso;
        this.compatibilityWithChildren = compatibilityWithChildren;
    }

    public String getDomesticUso() {
        return domesticUso;
    }

    public void setDomesticUso(String domesticUso) {
        this.domesticUso = domesticUso;
    }

    public boolean isCompatibilityWithChildren() {
        return compatibilityWithChildren;
    }

    public void setCompatibilityWithChildren(boolean compatibilityWithChildren) {
        this.compatibilityWithChildren = compatibilityWithChildren;
    }

    @Override
    public String toString() {
        return "DomesticAnimal{" +
                "domesticUso='" + domesticUso + '\'' +
                ", compatibilityWithChildren=" + compatibilityWithChildren +
                '}';
    }
}
