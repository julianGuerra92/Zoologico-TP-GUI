package com.example.zoologico.models;

import com.example.zoologico.interfaces.AnimalBehavior;

import java.time.LocalDate;
import java.util.Locale;

/**
 * @author Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa al tipo de animal doméstico destinado para la operación de adopción
 * (perros, gatos, conejos, hamster, etc.), quienes heredan de la clase Animal e implementan
 * la interface AnimalBehavior.
 */
public class AdoptionAnimal extends Animal implements AnimalBehavior {

    private String name;
    private boolean sterilized, available;

    public AdoptionAnimal() {
    }

    public AdoptionAnimal(
            String id,
            String scientificName,
            String species,
            LocalDate birthDate,
            String name,
            boolean sterilized,
            boolean available
    ) {
        super(id, scientificName, species, birthDate);
        this.name = name;
        this.sterilized = sterilized;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "AdoptionAnimal{" +
                "name='" + name + '\'' +
                ", sterilized=" + sterilized +
                ", available=" + available +
                '}';
    }

    @Override
    public String eat() {
        return name + " está comiendo en su plato favorito!";
    }

    @Override
    public String drinkingWater() {
        return name + " bebe agua en su bebedero!";
    }

    @Override
    public String sleep() {
        return "Silecio. " + name + " duerme en su cama en este momento.";
    }

}


