package org.example.subsistemas;

// API o Servicio de Pagos
public class ServicioPago {

    public boolean cobrar(String idCliente, double monto) {
        System.out.println("Cobrando $" + monto + " al cliente " + idCliente + " mediante pasarela de pagos.");
        return true;
    }

}
