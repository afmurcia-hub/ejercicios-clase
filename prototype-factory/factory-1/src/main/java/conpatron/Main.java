package conpatron;

import model.Vehiculo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CON FACTORY NORMAL ===");

        TruckFactory factory = new TruckFactory();

        // El cliente solo pide la potencia deseada, la factoría hace el resto
        Vehiculo camion400 = factory.createTruck(400);
        camion400.start();


        Vehiculo camion500 = factory.createTruck(500);
        camion500.start();
    }
}
