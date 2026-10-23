package org.example.listeners;


import org.example.events.EventListenerTienda;
import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;

public class NotificadorWhatsAppListener implements EventListenerTienda {

    @Override
    public void update(TipoEventoTienda tipoEvento, DatosEventoPedido data) {
        System.out.printf(" [WhatsApp]: Hola %s, tu pedido %s ya está en camino.%n",
                data.clienteEmail(), data.idPedido());
        
    }
}
