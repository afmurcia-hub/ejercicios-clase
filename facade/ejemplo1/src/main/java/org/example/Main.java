package org.example;


public class Main {

    public static void main(String[] args) {
        ManagerFlightsFacade managerFlights = new ManagerFlightsFacade();
        managerFlights.bookFlight("Juan Pérez", "City A", "City B", "2026-10-14");
    }
}
