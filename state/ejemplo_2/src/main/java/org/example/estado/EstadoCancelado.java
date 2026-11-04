package org.example.estado;

import org.example.contexto.Pedido;

public class EstadoCancelado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Error: No se puede pagar un pedido cancelado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Error: No se puede enviar un pedido cancelado.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Error: No se puede entregar un pedido cancelado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("El pedido ya se encuentra cancelado.");
    }
}
