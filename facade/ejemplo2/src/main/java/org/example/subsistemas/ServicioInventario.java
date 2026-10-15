package org.example.subsistemas;

// API o Servicio de Inventario / Bodega
public class ServicioInventario {

    public boolean verificarYReservarStock(String idProducto, int cantidad) {
        System.out.println("Reservando " + cantidad + " unidades del producto " + idProducto + " en bodega.");
        return true;
    }
}
