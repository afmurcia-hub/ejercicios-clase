package org.example.modulos;

import org.example.mediador.MediadorProcesos;
import org.example.modelo.ContextoTransaccion;

public class ModuloLogistica {
    private MediadorProcesos mediador;

    public void setMediador(MediadorProcesos mediador) { this.mediador = mediador; }

    public void prepararEnvio(ContextoTransaccion contexto) {
        String guia = "GUIA-" + System.currentTimeMillis();
        contexto.setCodigoEnvio(guia);
        System.out.println("  -> [ModuloLogistica] Guía de despacho generada: " + guia);
    }
}
