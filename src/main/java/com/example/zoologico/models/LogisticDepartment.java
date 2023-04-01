package com.example.zoologico.models;



import com.example.zoologico.Zoologico;

import java.time.LocalDate;

public class LogisticDepartment {

    public static void zooAdministration() {

    }

    public static String enterAnimal(
            String id,
            String scientificName,
            String species,
            LocalDate birthDate,
            String dangerLevel,
            String naturalHabitat,
            String compatibilityLevel
    ) {
        WildAnimal newAnimal = new WildAnimal(id, scientificName, species, birthDate, dangerLevel, naturalHabitat, compatibilityLevel);
        Zoologico.inventoryWildAnimal.add(newAnimal);
        return "El animal salvaje de la especie " + species + " ha sido ingresado correctamente";
    }

    public static String enterAnimal(
            String id,
            String scientificName,
            String species,
            LocalDate birthDate,
            String domesticUso,
            boolean compatibilityWithChildren
    ) {
        DomesticAnimal newAnimal = new DomesticAnimal(id, scientificName, species, birthDate, domesticUso, compatibilityWithChildren);
        Zoologico.inventoryDomesticAnimal.add(newAnimal);
        return "El animal domestico de la especie " + species + " ha sido ingresado correctamente";
    }

    public static String enterAnimal(
            String id,
            String scientificName,
            String species,
            LocalDate birthDate,
            String name,
            boolean sterilized,
            boolean available
    ) {
        AdoptionAnimal newAnimal = new AdoptionAnimal(id, scientificName, species, birthDate, name, sterilized, available);
        Zoologico.inventoryAdoptionAnimal.add(newAnimal);
        return "El animal domestico de la especie " + species + " ha sido ingresado correctamente";
    }

    public static String feedAnimal(Animal animal){
        return "El animal " + animal.getId() + " ha sido alimentado con éxito!";
    }

    public static boolean deliverAdoptedAnimal(String idAnimal) {
        for(AdoptionAnimal animal : Zoologico.inventoryAdoptionAnimal) {
            if(animal.getId() == idAnimal) {
                Zoologico.inventoryAdoptionAnimal.remove(animal);
                return true;
            }
        }
        return false;
    }


}
