package org.example.states;

import org.example.context.Reproductor;

public class EstadoReproduciendo implements Estado {

    @Override
    public void reproducir(Reproductor reproductor) {
        System.out.println("El reproductor ya está reproduciendo música.");
    }

    @Override
    public void pausar(Reproductor reproductor) {
        System.out.println("Pausando la reproducción...");
        reproductor.setEstado(new EstadoPausado());
    }

    @Override
    public void detener(Reproductor reproductor) {
        System.out.println("Deteniendo la reproducción...");
        reproductor.setEstado(new EstadoDetenido());
    }
}