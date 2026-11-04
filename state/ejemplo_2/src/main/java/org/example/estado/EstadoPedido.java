package org.example.estado;

import org.example.contexto.Pedido;

public interface EstadoPedido {
    void pagar(Pedido pedido);
    void enviar(Pedido pedido);
    void entregar(Pedido pedido);
    void cancelar(Pedido pedido);
}
