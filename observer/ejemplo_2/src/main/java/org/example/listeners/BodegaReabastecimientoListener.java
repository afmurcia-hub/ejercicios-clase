package org.example.listeners;


import org.example.events.EventListenerTienda;
import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;

public class BodegaReabastecimientoListener implements EventListenerTienda {
    @Override
    public void update(TipoEventoTienda tipoEvento, DatosEventoPedido data) {
        System.out.printf(" [BODEGA Y PROVEEDORES]: Alerta en SKU '%s'. Solo quedan %d unidades. " +
                        "Generando orden de compra automática al distribuidor.%n",
                data.skuProducto(), data.stockRestante());
    }
}
