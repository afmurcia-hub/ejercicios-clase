package org.example;

public class AvionComercial extends Avion {

    public AvionComercial(TorreControlMediator torre, String codigoVuelo) {
        super(torre, codigoVuelo);
    }

    public void solicitarAterrizar() {
        System.out.println("[" + codigoVuelo + "] Avión Comercial solicita pista para aterrizar.");
        torre.solicitarAterrizaje(this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("[" + codigoVuelo + "] Mensaje de la torre recibido: " + mensaje);
    }
}
