package org.example;


import org.example.interfaces.Observador;
import org.example.publisher.Producto;
import org.example.subscribers.ClienteAppMovil;
import org.example.subscribers.SistemaAuditoriaLog;

public class Main {
    public static void main(String[] args) {

        // 1. Creamos el Sujeto (Observable)
        Producto monitor = new Producto("Monitor Samsung 24", 650000.0);

        // 2. Creamos los Observadores (Suscriptores)
        Observador cliente1 = new ClienteAppMovil("andres");
        Observador cliente2 = new ClienteAppMovil("laura");
        Observador logger = new SistemaAuditoriaLog();

        // 3. Suscribimos los observadores al producto
        monitor.suscribir(cliente1);
        monitor.suscribir(cliente2);
        monitor.suscribir(logger);

        // 4. Primer cambio de estado (Notifica a los 3)
        monitor.setPrecio(580000.0);

        // 5. Un usuario decide desactivar las notificaciones (se desuscribe en caliente)
        System.out.println("\n--- @laura se desuscribe del producto ---");
        monitor.desuscribir(cliente2);

        // 6. Segundo cambio de estado (Solo notifica a andres_dev y al logger)
        monitor.setPrecio(520000.0);

    }
}