package org.example.modulos;

import org.example.mediador.MediadorProcesos;
import org.example.modelo.ContextoTransaccion;

public class ModuloFraude {
    private MediadorProcesos mediador;

    public void setMediador(MediadorProcesos mediador) { this.mediador = mediador; }

    public void evaluarRiesgo(ContextoTransaccion contexto) {
        System.out.println("  -> [ModuloFraude] Analizando comportamiento del cliente: " + contexto.getCliente());
        // Simulamos análisis exitoso
        contexto.setAprobadoPorFraude(true);
    }
}
