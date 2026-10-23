package org.example.interfaces;


import org.example.model.CotizacionReal;

@FunctionalInterface
public interface ObservadorCripto {
    void actualizar(CotizacionReal cotizacion);
}
