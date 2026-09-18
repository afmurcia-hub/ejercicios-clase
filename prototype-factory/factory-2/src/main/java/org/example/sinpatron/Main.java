package org.example.sinpatron;

public class Main {
    public static void main(String[] args) {

        // --- OPCIÓN A: Creación directa e explícita ---
        // La clase Main depende directamente de Car, Motorcycle y Truck


        Vehiculo car = new Car();
        car.start();

        Vehiculo motorcycle = new Motorcycle();
        motorcycle.start();

        Vehiculo truck = new Truck();
        truck.start();


//        // --- OPCIÓN B: Lógica de selección con condicionales dentro del cliente ---
//        // Si el cliente necesita decidir qué vehículo instanciar según un parámetro:
//        String tipoVehiculo = "car";
//        Vehiculo vehiculoSeleccionado;
//
//        if (tipoVehiculo.equalsIgnoreCase("car")) {
//            vehiculoSeleccionado = new Car();
//        } else if (tipoVehiculo.equalsIgnoreCase("motorcycle")) {
//            vehiculoSeleccionado = new Motorcycle();
//        } else if (tipoVehiculo.equalsIgnoreCase("truck")) {
//            vehiculoSeleccionado = new Truck();
//        } else {
//            vehiculoSeleccionado = null;
//        }
//
//        if (vehiculoSeleccionado != null) {
//            vehiculoSeleccionado.start();
//        }







    }
}