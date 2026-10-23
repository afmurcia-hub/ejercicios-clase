package org.example.events;

import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;


public interface EventListenerTienda {
    void update(TipoEventoTienda tipoEvento, DatosEventoPedido data);
}
