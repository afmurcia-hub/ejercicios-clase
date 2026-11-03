package org.example;

// Estrategia 1: Tarjeta de Crédito
public class PagoTarjeta implements EstrategiaPago {
    private String numeroTarjeta;
    private String cvv;

    public PagoTarjeta(String numeroTarjeta, String cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
    }

    @Override
    public boolean realizarPago(double monto) {
        System.out.println("💳 Procesando cobro de $" + monto + " a la tarjeta " + numeroTarjeta);
        // Conexión con la pasarela bancaria...
        return true;
    }
}