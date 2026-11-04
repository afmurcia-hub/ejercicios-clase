package org.example;

import org.example.contexto.SistemaRiego;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SistemaRiego sistema = new SistemaRiego();

        System.out.println("=== MONITOREO DE CLIMA CON PATRÓN STATE ===");

        // 1. Chicó, Bogotá
        sistema.monitorearUbicacion("El Chicó (Bogotá)", 4.6768, -74.0483);
        Thread.sleep(1500); 

        // 2. Amazonas (Leticia)
        sistema.monitorearUbicacion("Amazonas (Leticia)", -4.2153, -69.9406);
        Thread.sleep(1500);

        // 3. Medellin
        sistema.monitorearUbicacion("Medellín", 6.2442, -75.5812);
        Thread.sleep(1500);

        // 4. San Andres Isla
        sistema.monitorearUbicacion("San Andrés Isla", 12.5847, -81.7006);
        Thread.sleep(1500);

        // 5. Bogotá (Centro)
        sistema.monitorearUbicacion("Bogotá (Centro)", 4.6097, -74.0817);
        Thread.sleep(1500);

        // 6. Londres (Reino Unido)
        sistema.monitorearUbicacion("Londres (Reino Unido)", 51.5074, -0.1278);



    }
}