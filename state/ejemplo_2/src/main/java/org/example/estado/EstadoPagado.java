package org.example.estado;

import org.example.contexto.Pedido;

public class EstadoPagado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Error: El pedido ya ha sido pagado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("El pedido ha sido despachado y está en tránsito.");
        pedido.setEstado(new EstadoEnviado());
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Error: El pedido aún no ha sido despachado.");
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Procesando reembolso y cancelando el pedido...");
        pedido.setEstado(new EstadoCancelado());
    }
}
