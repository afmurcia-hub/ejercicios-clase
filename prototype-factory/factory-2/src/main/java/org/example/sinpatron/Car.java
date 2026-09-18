package org.example.sinpatron;

// Implementación concreta para Carro
public class Car implements Vehiculo {
    @Override
    public void start() {
        System.out.println("Run car");
    }

    @Override
    public void stop() {
        System.out.println("Stop car");
    }
}