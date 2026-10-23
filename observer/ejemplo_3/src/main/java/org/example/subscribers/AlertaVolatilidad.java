package org.example.subscribers;

import org.example.interfaces.ObservadorCripto;
import org.example.model.CotizacionReal;

public class AlertaVolatilidad implements ObservadorCripto {
    private final double umbralDolares;

    public AlertaVolatilidad(double umbralDolares) {
        this.umbralDolares = umbralDolares;
    }

    @Override
    public void actualizar(CotizacionReal c) {
        // Math.abs convierte negativos en positivos (ej: -15.0 pasa a 15.0) para medir el salto total
        if (Math.abs(c.diferenciaUsd()) >= umbralDolares) {
            System.out.printf("   ⚡ [ALERTA VOLATILIDAD]: ¡Movimiento brusco mayor a $%.2f USD! (%+,.2f USD)%n",
                    umbralDolares, c.diferenciaUsd());
        }
    }
}