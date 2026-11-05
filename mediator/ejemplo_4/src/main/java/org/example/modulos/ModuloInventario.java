package org.example.modulos;

import org.example.mediador.MediadorProcesos;
import org.example.modelo.ContextoTransaccion;

public class ModuloInventario {
    private MediadorProcesos mediador;

    public void setMediador(MediadorProcesos mediador) { this.mediador = mediador; }

    public void reservar(ContextoTransaccion contexto) {
        System.out.println("  -> [ModuloInventario] Apartando ítems en bodega central...");
        contexto.setStockReservado(true);
    }

    public void revertirReserva(ContextoTransaccion contexto) {
        System.out.println("  -> [ModuloInventario] Compensación: Devolviendo stock a bodega.");
        contexto.setStockReservado(false);
    }
}
