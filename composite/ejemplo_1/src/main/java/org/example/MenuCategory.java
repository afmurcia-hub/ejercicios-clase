package org.example;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory implements MenuComponent {
    private String name;
    private List<MenuComponent> menuComponents;

    public MenuCategory(String name) {
        this.name = name;
        this.menuComponents = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void add(MenuComponent component) {
        menuComponents.add(component);
    }

    @Override
    public void print() {
        System.out.println("\n[ CATEGORÍA ] ===> " + name);
        System.out.println("----------------------------------------");
        for (MenuComponent component : menuComponents) {
            component.print();
        }
    }
}