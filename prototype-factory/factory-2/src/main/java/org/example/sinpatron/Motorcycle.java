package org.example.sinpatron;

// Implementación concreta para Motocicleta
public class Motorcycle implements Vehiculo {
    @Override
    public void start() {
        System.out.println("Run motorcycle");
    }

    @Override
    public void stop() {
        System.out.println("Stop motorcycle");
    }
}