package org.example.listeners;


import org.example.events.EventListenerTienda;
import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;

public class SeguridadAntifraudeListener implements EventListenerTienda {

    @Override
    public void update(TipoEventoTienda tipoEvento, DatosEventoPedido data) {
        System.out.printf(" [SEGURIDAD]: Bloqueando IP y cuenta de %s. Motivo: %s ($%,.2f)%n",
                data.clienteEmail(), data.detalle(), data.montoTotal());
    }
}
