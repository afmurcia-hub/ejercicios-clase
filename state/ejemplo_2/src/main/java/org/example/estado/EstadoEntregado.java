package org.example.estado;

import org.example.contexto.Pedido;

public class EstadoEntregado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Error: El pedido ya fue completado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Error: El pedido ya fue entregado previamente.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("El pedido ya figura como entregado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Error: No se puede cancelar un pedido ya entregado.");
    }
}
