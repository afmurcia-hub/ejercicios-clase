package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Pedido pedido1 = new Pedido(250.0);

        // El usuario elige PayPal en la interfaz
        pedido1.setMetodoPago(new PagoPayPal("cliente@correo.com"));
        pedido1.procesarPedido();

        // Otro usuario prefiere pagar con Tarjeta de Crédito
        Pedido pedido2 = new Pedido(1200.0);
        pedido2.setMetodoPago(new PagoTarjeta("4532-1111-2222-8901", "123"));
        pedido2.procesarPedido();
    }
}