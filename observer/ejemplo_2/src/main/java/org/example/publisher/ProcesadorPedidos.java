package org.example.publisher;

import org.example.events.EventManagerEcommerce;
import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;

import java.util.HashMap;
import java.util.Map;

public class ProcesadorPedidos {

    public final EventManagerEcommerce events;
    private final Map<String, Integer> inventarioBodega = new HashMap<>();

    public ProcesadorPedidos() {

        this.events = new EventManagerEcommerce();

        // Cargamos 5 unidades al inventario
        inventarioBodega.put("Portatil dell", 5);
    }

    public void procesarCheckout(String idPedido, String email, String sku, int cantidad, double precioUnitario) {

        double total = cantidad * precioUnitario;

        System.out.printf("%n [CHECKOUT %s] Procesando compra de %d x %s para %s (Total: $%,.2f)%n",
                idPedido, cantidad, sku, email, total);


        // Regla 1: Si una sola compra supera los $15,000,000 COP, se marca como posible fraude
        if (total > 15_000_000) {
            DatosEventoPedido alerta = new DatosEventoPedido(
                    idPedido, email, sku, total, inventarioBodega.getOrDefault(sku, 0),
                    "Transacción inusualmente alta rechazada por pasarela"
            );
            events.notify(TipoEventoTienda.ALERTA_FRAUDE, alerta);
            return;
        }

        // Regla 2: Descontar inventario y aprobar pago
        int stockActual = inventarioBodega.getOrDefault(sku, 0) - cantidad;
        inventarioBodega.put(sku, stockActual);

        DatosEventoPedido exito = new DatosEventoPedido(
                idPedido, email, sku, total, stockActual, "Pago procesado con éxito"
        );
        events.notify(TipoEventoTienda.PAGO_APROBADO, exito);

        // Regla 3: Si quedan 2 o menos unidades en bodega, disparar alerta de reabastecimiento
        if (stockActual <= 2) {
            DatosEventoPedido alertaStock = new DatosEventoPedido(
                    idPedido, email, sku, total, stockActual, "¡Quedan pocas unidades en bodega!"
            );
            events.notify(TipoEventoTienda.STOCK_CRITICO, alertaStock);
        }
    }
}
