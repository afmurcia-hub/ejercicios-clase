package org.example.estado;

import org.example.contexto.SistemaRiego;

public interface EstadoClima {
    void ejecutarAccionRiego(SistemaRiego sistema);
    void evaluarCambioEstado(SistemaRiego sistema, double temperatura, double viento, int codigoClima);
}
