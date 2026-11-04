package org.example.states;

import org.example.context.Reproductor;

public interface Estado {
    void reproducir(Reproductor reproductor);
    void pausar(Reproductor reproductor);
    void detener(Reproductor reproductor);
}
