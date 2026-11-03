package org.example;


// Estrategia 3: Criptomonedas (Bitcoin)
public class PagoCripto implements EstrategiaPago {
    private String direccionWallet;

    public PagoCripto(String direccionWallet) {
        this.direccionWallet = direccionWallet;
    }

    @Override
    public boolean realizarPago(double monto) {
        System.out.println("₿ Transfiriendo $" + monto + " en Bitcoin a la billetera: " + direccionWallet);
        // Conexión con la red Blockchain...
        return true;
    }
}