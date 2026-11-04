package org.example.states;

import org.example.context.Reproductor;

public class EstadoPausado implements Estado {

    @Override
    public void reproducir(Reproductor reproductor) {
        System.out.println("Reanudando la reproducción...");
        reproductor.setEstado(new EstadoReproduciendo());
    }

    @Override
    public void pausar(Reproductor reproductor) {
        System.out.println("El reproductor ya está en pausa.");
    }

    @Override
    public void detener(Reproductor reproductor) {
        System.out.println("Deteniendo el reproductor desde la pausa...");
        reproductor.setEstado(new EstadoDetenido());
    }
}
