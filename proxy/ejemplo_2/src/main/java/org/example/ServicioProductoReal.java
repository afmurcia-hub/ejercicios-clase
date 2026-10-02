package org.example;

public class ServicioProductoReal implements ServicioProducto {

    public ServicioProductoReal() {
        System.out.println("[BD E-COMMERCE] Conectando con el servidor central de inventario...");
    }

    @Override
    public String obtenerDetalleProducto(String idProducto) {
        System.out.println("[BD E-COMMERCE] Consultando tabla de productos para ID: " + idProducto + "...");
        try {
            // Simula el tiempo de respuesta de una base de datos pesada
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Producto: Laptop  | Stock: 15 unidades | Precio: $1900000 ";
    }
}
