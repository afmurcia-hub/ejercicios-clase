package org.example;

// Estrategia 2: PayPal
public class PagoPayPal implements EstrategiaPago {
    private String email;

    public PagoPayPal(String email) {
        this.email = email;
    }

    @Override
    public boolean realizarPago(double monto) {
        System.out.println("🟦 Procesando cobro de $" + monto + " a través de la cuenta PayPal: " + email);
        // Conexión con la API de PayPal...
        return true;
    }
}