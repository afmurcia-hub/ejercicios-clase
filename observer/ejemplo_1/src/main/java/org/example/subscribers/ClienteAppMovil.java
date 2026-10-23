package org.example.subscribers;


import org.example.interfaces.Observador;

public class ClienteAppMovil implements Observador {
    private final String usuario;

    public ClienteAppMovil(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public void actualizar(String nombreProducto, double nuevoPrecio) {
        System.out.println(" [App Móvil -> @" + usuario + "]: ¡Aprovecha! "
                + nombreProducto + " bajó a $" + nuevoPrecio);
    }
}