package org.example.sinpatron;
import model.GPSModule;
import model.MotorDiesel;
import model.Licencia;


public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIN PATRÓN ===");

        // --- Crear un Camión de 400 HP ---
        // El cliente debe saber cómo armar un GPS, un Motor y consultar la Licencia
        GPSModule gps1 = new GPSModule("v2.1");
        MotorDiesel motor1 = new MotorDiesel(400);
        Licencia licencia1 = new Licencia("Especial C3");

        Truck camion400 = new Truck(gps1, motor1, licencia1);
        camion400.asignarRutaInicial();
        camion400.start();





        // --- Crear un Camión de 500 HP ---
        // Se debe repetir toda la lógica de ensamblado en el cliente
        GPSModule gps2 = new GPSModule("v2.1");
        MotorDiesel motor2 = new MotorDiesel(500); // Variación del motor
        Licencia licencia2 = new Licencia("Especial C3");

        Truck camion500 = new Truck(gps2, motor2, licencia2);
        camion500.asignarRutaInicial();
        camion500.start();
    }

}