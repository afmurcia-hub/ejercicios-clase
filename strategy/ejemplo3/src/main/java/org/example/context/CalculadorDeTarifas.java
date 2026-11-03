package org.example.context;

import org.example.model.DetalleViaje;
import org.example.strategy.EstrategiaTarifa;

public class CalculadorDeTarifas {
    private EstrategiaTarifa estrategia;

    public CalculadorDeTarifas(EstrategiaTarifa estrategiaInicial) {
        this.estrategia = estrategiaInicial;
    }

    public void setEstrategia(EstrategiaTarifa nuevaEstrategia) {
        this.estrategia = nuevaEstrategia;
    }

    public double obtenerCotizacion(DetalleViaje viaje) {
        if (estrategia == null) {
            throw new IllegalStateException("No se ha configurado ninguna estrategia de cálculo.");
        }
        return estrategia.calcularPrecio(viaje);
    }
}
