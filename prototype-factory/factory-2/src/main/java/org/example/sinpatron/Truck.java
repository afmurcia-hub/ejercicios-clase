package org.example.sinpatron;

// Implementación concreta para Camión
public class Truck implements Vehiculo {
    @Override
    public void start() {
        System.out.println("Run truck");
    }

    @Override
    public void stop() {
        System.out.println("Stop truck");
    }
}
