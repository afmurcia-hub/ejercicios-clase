package org.example.Facade;

import org.example.subsistemas.ServicioInventario;
import org.example.subsistemas.ServicioLogistica;
import org.example.subsistemas.ServicioNotificacion;
import org.example.subsistemas.ServicioPago;

public class FachadaProcesamientoPedidos {

    private final ServicioPago servicioPago;
    private final ServicioInventario servicioInventario;
    private final ServicioLogistica servicioLogistica;
    private final ServicioNotificacion servicioNotificacion;

    public FachadaProcesamientoPedidos() {
        this.servicioPago = new ServicioPago();
        this.servicioInventario = new ServicioInventario();
        this.servicioLogistica = new ServicioLogistica();
        this.servicioNotificacion = new ServicioNotificacion();
    }

    public boolean procesarPedido(String idCliente, String correo, String idProducto, int cantidad, double total, String direccion) {
        System.out.println("\n--- Iniciando procesamiento de pedido ---");

        // 1. Validar y apartar existencias
        if (!servicioInventario.verificarYReservarStock(idProducto, cantidad)) {
            System.out.println("Error: No hay suficiente inventario disponible.");
            return false;
        }

        // 2. Realizar el cobro
        if (!servicioPago.cobrar(idCliente, total)) {
            System.out.println("Error: Pago rechazado.");
            return false;
        }

        // 3. Crear el envío con la transportadora
        String numeroGuia = servicioLogistica.generarGuiaEnvio(direccion, idProducto);

        // 4. Enviar notificación al comprador
        servicioNotificacion.enviarConfirmacion(correo, numeroGuia);

        System.out.println("--- Pedido procesado exitosamente ---\n");
        return true;
    }
}
