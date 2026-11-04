package org.example.contexto;

import org.example.estado.EstadoPedido;
import org.example.estado.EstadoPendiente;

public class Pedido {

    private EstadoPedido estado;

    private final String idPedido;

    public Pedido(String idPedido) {
        this.idPedido = idPedido;
        // Inicia siempre en estado Pendiente
        this.estado = new EstadoPendiente();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getIdPedido() {
        return idPedido;
    }

    // Delegación de operaciones al estado actual
    public void pagar() {
        estado.pagar(this);
    }

    public void enviar() {
        estado.enviar(this);
    }

    public void entregar() {
        estado.entregar(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }
}

