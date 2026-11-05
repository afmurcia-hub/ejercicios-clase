package org.example.modulos;

import org.example.mediador.MediadorProcesos;
import org.example.modelo.ContextoTransaccion;

public class ModuloPagos {
    private MediadorProcesos mediador;

    public void setMediador(MediadorProcesos mediador) { this.mediador = mediador; }

    public void cobrar(ContextoTransaccion contexto) {
        System.out.println("  -> [ModuloPagos] Procesando cargo de $" + contexto.getMonto() + " a la tarjeta...");
        contexto.setPagoProcesado(true);
    }
}
