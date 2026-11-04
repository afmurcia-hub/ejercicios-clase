package org.example.estado;

import org.example.contexto.SistemaRiego;

public class EstadoDespejado implements EstadoClima {

    @Override
    public void ejecutarAccionRiego(SistemaRiego sistema) {
        System.out.println("☀️ [ESTADO DESPEJADO] Riego activado al 100%. Cultivos hidratándose.");
    }


    // REGLA DE NEGOCIO: Evaluación de transición de estado desde Viento.
// -------------------------------------------------------------------------------------
// Param 'viento': Velocidad en km/h. Veinte o menos indica viento seguro o tranquilo.
// Param 'codigoClima': Estándar OMM/WMO (cero a cuarenta y nueve: Seco o Sin lluvia | cincuenta o más: Llovizna o Lluvia).
//
// 1. (viento igual o menor a 20 Y clima menor a 50): Viento calmo Y sin lluvia -> Normaliza a EstadoDespejado.
// 2. (clima igual o mayor a 50): Hay lluvia activa -> Transiciona a EstadoLluvia.
// 3. De lo contrario: Mantiene el estado actual por persistencia de viento fuerte seco.

    
    @Override
    public void evaluarCambioEstado(SistemaRiego sistema, double temperatura, double viento, int codigoClima) {

        if (codigoClima >= 50) {
            System.out.println("🌧️ API detecta lluvia en curso. Cambiando a -> ESTADO LLUVIA.");
            sistema.setEstado(new EstadoLluvia());
        } else if (viento > 25.0) {
            System.out.println("💨 API detecta vientos fuertes (" + viento + " km/h). Cambiando a -> ESTADO ALERTA VIENTO.");
            sistema.setEstado(new EstadoAlertaViento());
        }
    }
}
