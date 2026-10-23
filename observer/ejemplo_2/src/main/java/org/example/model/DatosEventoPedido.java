package org.example.model;



import java.time.LocalDateTime;

public record DatosEventoPedido(
        String idPedido,
        String clienteEmail,
        String skuProducto,
        double montoTotal,
        int stockRestante,
        String detalle,
        LocalDateTime fechaHora
) {
    public DatosEventoPedido(String idPedido, String clienteEmail, String skuProducto,
                             double montoTotal, int stockRestante, String detalle) {
        this(idPedido, clienteEmail, skuProducto, montoTotal, stockRestante, detalle, LocalDateTime.now());
    }
}
