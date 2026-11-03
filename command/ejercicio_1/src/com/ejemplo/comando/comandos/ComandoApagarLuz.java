package com.ejemplo.comando.comandos;

import com.ejemplo.comando.core.Comando;
import com.ejemplo.comando.receptor.Luz;

/**
 * Comando Concreto para apagar la luz.
 */
public class ComandoApagarLuz implements Comando {

    private Luz luz;

    public ComandoApagarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void ejecutar() {
        luz.apagar();
    }

    @Override
    public void deshacer() {
        luz.encender();
    }

    @Override
    public String obtenerNombre() {
        return "Apagar Luz (" + luz.obtenerUbicacion() + ")";
    }
}
