package org.example.estado;

import org.example.contexto.Pedido;

public class EstadoPendiente implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Pago procesado con éxito.");
        pedido.setEstado(new EstadoPagado());
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Error: No se puede enviar un pedido sin pagar.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Error: No se puede entregar un pedido no enviado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Pedido cancelado exitosamente.");
        pedido.setEstado(new EstadoCancelado());
    }
}
