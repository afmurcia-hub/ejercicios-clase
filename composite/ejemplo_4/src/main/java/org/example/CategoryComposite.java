package org.example;

import java.util.ArrayList;
import java.util.List;

public class CategoryComposite implements CatalogComponent {
    private String categoryName;
    private List<CatalogComponent> children = new ArrayList<>();

    public CategoryComposite(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addComponent(CatalogComponent component) {
        children.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("\n📂 Departamento / Categoría: " + categoryName);
        for (CatalogComponent component : children) {
            component.showDetails(); // Recursividad
        }
    }

    @Override
    public double getTotalPrice() {
        double total = 0;
        for (CatalogComponent component : children) {
            total += component.getTotalPrice(); // Suma recursiva de precios de la API
        }
        return total;
    }
}