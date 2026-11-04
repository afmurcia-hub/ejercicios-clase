package org.example.states;

import org.example.context.Reproductor;

public class EstadoDetenido implements Estado {

    @Override
    public void reproducir(Reproductor reproductor) {
        System.out.println("Iniciando la reproducción...");
        reproductor.setEstado(new EstadoReproduciendo());
    }

    @Override
    public void pausar(Reproductor reproductor) {
        System.out.println("No se puede pausar: el reproductor está detenido.");
    }

    @Override
    public void detener(Reproductor reproductor) {
        System.out.println("El reproductor ya se encuentra detenido.");
    }
}