package org.example.eventos;

public class EventoVuelo {
    private final TipoEvento tipo;
    private final String idVuelo;
    private final String detalles;

    public EventoVuelo(TipoEvento tipo, String idVuelo, String detalles) {
        this.tipo = tipo;
        this.idVuelo = idVuelo;
        this.detalles = detalles;
    }

    public TipoEvento getTipo() { return tipo; }
    public String getIdVuelo() { return idVuelo; }
    public String getDetalles() { return detalles; }
}
