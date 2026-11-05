package org.example.mediador;

import org.example.eventos.EventoVuelo;

public interface MediadorAeropuerto {
    void notificar(EventoVuelo evento);
}
