package org.example;

public class MenuItem implements MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(MenuComponent component) {
        throw new UnsupportedOperationException("No se pueden agregar elementos a un plato individual (nodo hoja).");
    }

    @Override
    public void print() {
        System.out.println("  • Plato: " + name + " ---- Precio: $" + price);
    }
}
