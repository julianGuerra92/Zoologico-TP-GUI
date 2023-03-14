package com.example.zoologico.models;

import java.time.LocalDate;

/**
 * @author Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa al tipo de animales salvajes (leones, serpientes, jirafas, etc), quienes
 * heredan directamente de la clase animal.
 */
public class WildAnimal extends Animal {

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
}
