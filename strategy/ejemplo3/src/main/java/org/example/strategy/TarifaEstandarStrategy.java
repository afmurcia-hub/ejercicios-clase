package org.example.strategy;

import org.example.model.DetalleViaje;

// Estrategia 1: Tarifa Estándar
public class TarifaEstandarStrategy implements EstrategiaTarifa {
    private static final double TARIFA_BASE = 2.00;
    private static final double PRECIO_POR_KM = 1.20;
    private static final double PRECIO_POR_MINUTO = 0.30;

    @Override
    public double calcularPrecio(DetalleViaje viaje) {
        System.out.println("🟢 Aplicando algoritmo de Tarifa Estándar.");
        return TARIFA_BASE + (viaje.getDistanciaKm() * PRECIO_POR_KM) + (viaje.getDuracionMinutos() * PRECIO_POR_MINUTO);
    }
}

