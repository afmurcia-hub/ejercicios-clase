package org.example.estado;

import org.example.contexto.SistemaRiego;

public class EstadoAlertaViento implements EstadoClima {

    @Override
    public void ejecutarAccionRiego(SistemaRiego sistema) {
        System.out.println("💨 [ALERTA VIENTO] Riego suspendido para evitar desperdiciar agua por ráfagas.");
    }

    @Override
    public void evaluarCambioEstado(SistemaRiego sistema, double temperatura, double viento, int codigoClima) {
        if (viento <= 20.0 && codigoClima < 50) {
            System.out.println("☀️ El viento ha disminuido. Normalizando a -> ESTADO DESPEJADO.");
            sistema.setEstado(new EstadoDespejado());
        } else if (codigoClima >= 50) {
            System.out.println("🌧️ Comenzó a llover además del viento. Cambiando a -> ESTADO LLUVIA.");
            sistema.setEstado(new EstadoLluvia());
        }
    }
}
