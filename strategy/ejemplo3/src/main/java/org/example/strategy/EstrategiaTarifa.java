package org.example.strategy;

import org.example.model.DetalleViaje;

public interface EstrategiaTarifa {
    double calcularPrecio(DetalleViaje viaje);
}