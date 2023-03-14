package com.example.zoologico.models;

/**
 * enum para definir las categorias que deberán usarase en el momento de instancias un objeto
 * de la clase Plans.
 */
enum PlanCategory {
    GENERAL_NINIO_ADULTO,
    GENERAL_TODO_INCLUIDO,
    TOUR_GRANJA_TODO_INCLUIDO,
    ABONO_MENSUAL
}

/**
 * @author Julian A. Rodríguez G. - Oscar Albeiro Blandón
 * @version 0.0.1
 * Esta clase representa los planes que se crearan para el zoológico y extarán disponibles para la venta
 * a los diferentes clientes. Esta usa la enumeración PlanCategory.
 */
public class Plans {

    private String name;
    private PlanCategory category;
    private String description;
    private int quantity;
    private float price;
    private boolean allInclusive, available;

    public Plans() {
    }

    public Plans(
            String name,
            PlanCategory category,
            String description,
            int quantity,
            float price,
            boolean allInclusive
    ) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.allInclusive = allInclusive;
        available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(PlanCategory category) {
        this.category = category;
    }

    public PlanCategory getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = PlanCategory.valueOf(category);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAllInclusive() {
        return allInclusive;
    }

    public void setAllInclusive(boolean allInclusive) {
        this.allInclusive = allInclusive;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Plans{" +
                "category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", allInclusive=" + allInclusive +
                ", available=" + available +
                '}';
    }
}
