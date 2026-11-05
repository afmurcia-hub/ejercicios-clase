package org.example.mediador;

import org.example.modelo.ContextoTransaccion;

public interface MediadorProcesos {
    void ejecutarFlujoCompra(ContextoTransaccion contexto);
    void notificarFallaCritica(String moduloOrigen, String motivo, ContextoTransaccion contexto);
}
