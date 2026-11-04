package org.example.estado;

import org.example.contexto.Pedido;

public class EstadoEnviado implements EstadoPedido {

    @Override
    public void pagar(Pedido pedido) {
        System.out.println("Error: El pedido ya fue pagado y enviado.");
    }

    @Override
    public void enviar(Pedido pedido) {
        System.out.println("Error: El pedido ya se encuentra en camino.");
    }

    @Override
    public void entregar(Pedido pedido) {
        System.out.println("Pedido recibido por el cliente con éxito.");
        pedido.setEstado(new EstadoEntregado());
    }

    @Override
    public void cancelar(Pedido pedido) {
        System.out.println("Error: No se puede cancelar un pedido que ya está en tránsito.");
    }
}
