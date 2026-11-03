package org.example;

public class Pedido {
    private double montoTotal;
    private EstrategiaPago metodoPago;

    public Pedido(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    // Permite asignar la estrategia dinámicamente según la elección del usuario
    public void setMetodoPago(EstrategiaPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void procesarPedido() {
        if (metodoPago == null) {
            System.out.println("⚠️ Debe seleccionar un método de pago antes de continuar.");
            return;
        }

        boolean exito = metodoPago.realizarPago(montoTotal);
        if (exito) {
            System.out.println("✅ Pedido completado con éxito.\n");
        } else {
            System.out.println("❌ Falló el procesamiento del pago.\n");
        }
    }
}
