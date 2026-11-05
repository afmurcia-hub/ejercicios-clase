package org.example.colegas;

import org.example.eventos.EventoVuelo;
import org.example.eventos.TipoEvento;

public class AvionComercial extends ComponenteAeropuerto {
    private final String idVuelo;

    public AvionComercial(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public void solicitarAterrizaje() {
        // El avión no conoce a nadie, solo le lanza el evento al mediador
        mediador.notificar(new EventoVuelo(TipoEvento.AVION_ATERRIZADO, idVuelo, "Aterrizaje normal exitoso"));
    }

    public void declararEmergencia() {
        mediador.notificar(new EventoVuelo(TipoEvento.EMERGENCIA_TECNICA, idVuelo, "Falla de motores"));
    }

    @Override
    public void ejecutarAccion(String accion, String idVuelo) {
        // Los aviones también pueden recibir órdenes del mediador si aplica
    }
}
