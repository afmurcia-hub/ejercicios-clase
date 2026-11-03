package org.example.strategy;

import org.example.model.DetalleViaje;

// Estrategia 2: Hora Punta (Surge Pricing)
public class TarifaHoraPuntaStrategy implements EstrategiaTarifa {
    private static final double TARIFA_BASE = 3.00;
    private static final double PRECIO_POR_KM = 1.50;
    private static final double MULTIPLICADOR_DEMANDA = 2.2; // 220% por alta demanda

    @Override
    public double calcularPrecio(DetalleViaje viaje) {
        System.out.println("🔴 Aplicando algoritmo de Tarifa Hora Punta (Multiplicador x" + MULTIPLICADOR_DEMANDA + ").");
        double subtotal = TARIFA_BASE + (viaje.getDistanciaKm() * PRECIO_POR_KM);
        return subtotal * MULTIPLICADOR_DEMANDA;
    }
}