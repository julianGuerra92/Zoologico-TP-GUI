package com.example.zoologico.models;

import com.example.zoologico.interfaces.AnimalBehavior;

import java.time.LocalDate;

/**
 * @author Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa al tipo de animales salvajes (leones, serpientes, jirafas, etc), quienes
 * heredan de la clase Animal e implementan la interface AnimalBehavior.
 */
public class WildAnimal extends Animal implements AnimalBehavior {

    private String dangerLevel, naturalHabitat, compatibilityLevel;

    public WildAnimal() {
    }

    public WildAnimal(
            String id,
            String scientificName,
            String species,
            LocalDate birthDate,
            String dangerLevel,
            String naturalHabitat,
            String compatibilityLevel
    ) {
        super(id, scientificName, species, birthDate);
        this.dangerLevel = dangerLevel;
        this.naturalHabitat = naturalHabitat;
        this.compatibilityLevel = compatibilityLevel;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public String getNaturalHabitat() {
        return naturalHabitat;
    }

    public void setNaturalHabitat(String naturalHabitat) {
        this.naturalHabitat = naturalHabitat;
    }

    public String getCompatibilityLevel() {
        return compatibilityLevel;
    }

    public void setCompatibilityLevel(String compatibilityLevel) {
        this.compatibilityLevel = compatibilityLevel;
    }

    public String hunt() {
        return "Pongan atención, el animal está cazando!";
    }

    @Override
    public String toString() {
        return "WildAnimal{" +
                "dangerLevel='" + dangerLevel + '\'' +
                ", naturalHabitat='" + naturalHabitat + '\'' +
                ", compatibilityLevel='" + compatibilityLevel + '\'' +
                '}';
    }

    @Override
    public String eat() {
        return "El " + getSpecies() + " se encuentra devorando su presea!";
    }

    @Override
    public String drinkingWater() {
        return "Ahora el " + getSpecies() + " se encuentra bebiendo agua del estanque!";
    }

    @Override
    public String sleep() {
        return "Silecio. Animal salvaje durmiendo!";
    }

}
