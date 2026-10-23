package org.example.listeners;


import org.example.events.EventListenerTienda;
import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;

public class FacturacionElectronicaListener implements EventListenerTienda {
    private double ventasAcumuladasDia = 0.0;

    @Override
    public void update(TipoEventoTienda tipoEvento, DatosEventoPedido data) {
        ventasAcumuladasDia += data.montoTotal();
        System.out.printf(" [FACTURACIÓN]: Factura enviada a %s por $%,.2f (Pedido %s). Recaudo hoy: $%,.2f%n",
                data.clienteEmail(), data.montoTotal(), data.idPedido(), ventasAcumuladasDia);
    }
}