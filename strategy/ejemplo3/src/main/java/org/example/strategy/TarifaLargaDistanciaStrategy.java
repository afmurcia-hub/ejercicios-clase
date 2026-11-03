package org.example.strategy;

import org.example.model.DetalleViaje;

// Estrategia 3: Larga Distancia (Tarifa plana por km reducido)
public class TarifaLargaDistanciaStrategy implements EstrategiaTarifa {
    private static final double PRECIO_POR_KM_REDUCIDO = 0.85; // Descuento por volumen de km

    @Override
    public double calcularPrecio(DetalleViaje viaje) {
        System.out.println("🟡 Aplicando algoritmo de Larga Distancia (>50 km).");
        return viaje.getDistanciaKm() * PRECIO_POR_KM_REDUCIDO;
    }
}