package com.ejemplo.comando.core;

/**
 * Interfaz base
 */
public interface Comando {
    void ejecutar();
    void deshacer();
    String obtenerNombre();
}
