package org.example;

public abstract class Avion {

    protected TorreControlMediator torre;
    protected String codigoVuelo;

    public Avion(TorreControlMediator torre, String codigoVuelo) {
        this.torre = torre;
        this.codigoVuelo = codigoVuelo;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public abstract void recibirMensaje(String mensaje);
}

