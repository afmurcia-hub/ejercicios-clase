package com.ejemplo.comando.comandos;

import com.ejemplo.comando.core.Comando;
import com.ejemplo.comando.receptor.Luz;

/**
 * Comando Concreto para encender la luz.
 */
public class ComandoEncenderLuz implements Comando {

    private Luz luz;

    public ComandoEncenderLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutar() {
        luz.encender();
    }

    @Override
    public void deshacer() {
        luz.apagar();
    }

    @Override
    public String obtenerNombre() {
        return "Encender Luz (" + luz.obtenerUbicacion() + ")";
    }
}
