package org.example.estado;

import org.example.contexto.SistemaRiego;

public class EstadoLluvia implements EstadoClima {

    @Override
    public void ejecutarAccionRiego(SistemaRiego sistema) {
        System.out.println("🌧️ [ESTADO LLUVIA] Riego APAGADO. Aprovechando el agua de lluvia natural.");
    }

    @Override
    public void evaluarCambioEstado(SistemaRiego sistema, double temperatura, double viento, int codigoClima) {
        if (codigoClima < 50 && viento <= 25.0) {
            System.out.println("☀️ La lluvia se detuvo y el viento es calmo. Volviendo a -> ESTADO DESPEJADO.");
            sistema.setEstado(new EstadoDespejado());
        }
    }
}
