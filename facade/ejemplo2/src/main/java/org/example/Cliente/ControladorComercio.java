package org.example.Cliente;

import org.example.Facade.FachadaProcesamientoPedidos;

public class ControladorComercio {

    public static void main(String[] args) {
        FachadaProcesamientoPedidos fachadaPedidos = new FachadaProcesamientoPedidos();

        // El cliente solo llama a un metodo de alto nivel
        boolean resultado = fachadaPedidos.procesarPedido(
                "CLI-104",
                "andres@ejemplo.com",
                "PROD-PORTATIL-16",
                1,
                1250.00,
                "Cra 14 # 22-10, Armenia"
        );

        if (resultado) {
            System.out.println("Respuesta: Pedido confirmado y registrado con éxito.");
        }
    }
}