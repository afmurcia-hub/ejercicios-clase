package org.example.context;

import org.example.states.Estado;
import org.example.states.EstadoDetenido;

public class Reproductor {

    private Estado estado;

    public Reproductor() {
        // Estado inicial por defecto
        this.estado = new EstadoDetenido();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    // Métodos de negocio - delegación al estado activo
    public void reproducir() {
        estado.reproducir(this);
    }

    public void pausar() {
        estado.pausar(this);
    }

    public void detener() {
        estado.detener(this);
    }

}