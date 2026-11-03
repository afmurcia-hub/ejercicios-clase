package com.ejemplo.comando.core;

public interface Comando {
    void ejecutar();
    void deshacer();
    String obtenerNombre();
}
