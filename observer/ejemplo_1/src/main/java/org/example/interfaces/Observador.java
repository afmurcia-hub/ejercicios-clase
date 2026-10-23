package org.example.interfaces;

//Define el contrato que cualquier clase interesada en recibir notificaciones debe cumplir.
public interface Observador {
    void actualizar(String nombreProducto, double nuevoPrecio);
}