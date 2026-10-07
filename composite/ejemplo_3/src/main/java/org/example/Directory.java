package org.example;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileComponent {
    private String name;
    private List<FileComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directorio: " + name);
        for (FileComponent component : components) {
            component.showDetails(); 
        }
    }
}
