package org.example;

import org.example.contexto.Pedido;


public class Main {

    public static void main(String[] args) {

        System.out.println("= Caso 1: Flujo Exitoso Completo =");

        Pedido pedido1 = new Pedido("PED-101");

        pedido1.enviar();   // Intento inválido (aún no está pagado)
        pedido1.pagar();    // Pendiente -> Pagado
        pedido1.enviar();   // Pagado -> Enviado
        pedido1.entregar(); // Enviado -> Entregado


        System.out.println("\n= Caso 2: Intento de cancelación inválida =");
        pedido1.cancelar(); // Inválido porque ya fue entregado


        System.out.println("\n= Caso 3: Flujo con Cancelación y Reembolso =");
        Pedido pedido2 = new Pedido("PED-102");
        pedido2.pagar();    // Pendiente -> Pagado
        pedido2.cancelar(); // Pagado -> Cancelado (emite reembolso)
        pedido2.enviar();   // Inválido porque ya está cancelado
    }
}