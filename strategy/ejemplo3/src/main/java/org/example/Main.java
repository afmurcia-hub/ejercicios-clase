package org.example;

import org.example.context.CalculadorDeTarifas;
import org.example.model.DetalleViaje;
import org.example.strategy.EstrategiaTarifa;
import org.example.strategy.TarifaEstandarStrategy;
import org.example.strategy.TarifaHoraPuntaStrategy;
import org.example.strategy.TarifaLargaDistanciaStrategy;

public class Main {

    // Metodo selector que decide la mejor estrategia según las condiciones del viaje
    public static EstrategiaTarifa seleccionarEstrategia(DetalleViaje viaje) {
        if (viaje.getDistanciaKm() > 50) {
            return new TarifaLargaDistanciaStrategy();
        } else if (viaje.isAltaDemanda()) {
            return new TarifaHoraPuntaStrategy();
        } else {
            return new TarifaEstandarStrategy();
        }
    }

    public static void main(String[] args) {
        // Caso 1: Viaje corto urbano en hora normal
        DetalleViaje viaje1 = new DetalleViaje(8.5, 20, 14, false);
        CalculadorDeTarifas calculador = new CalculadorDeTarifas(seleccionarEstrategia(viaje1));
        double precio1 = calculador.obtenerCotizacion(viaje1);
        System.out.printf("Total Cotizado: $%.2f%n%n", precio1);

        // Caso 2: Viaje en hora de alta demanda (Hora Punta)
        DetalleViaje viaje2 = new DetalleViaje(8.5, 35, 18, true);
        calculador.setEstrategia(seleccionarEstrategia(viaje2));
        double precio2 = calculador.obtenerCotizacion(viaje2);
        System.out.printf("Total Cotizado: $%.2f%n%n", precio2);

        // Caso 3: Viaje interurbano de larga distancia
        DetalleViaje viaje3 = new DetalleViaje(120.0, 90, 10, false);
        calculador.setEstrategia(seleccionarEstrategia(viaje3));
        double precio3 = calculador.obtenerCotizacion(viaje3);
        System.out.printf("Total Cotizado: $%.2f%n%n", precio3);
    }
}