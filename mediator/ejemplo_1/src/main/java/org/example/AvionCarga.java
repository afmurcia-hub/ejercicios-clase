package org.example;

public class AvionCarga extends Avion {

    public AvionCarga(TorreControlMediator torre, String codigoVuelo) {
        super(torre, codigoVuelo);
    }

    public void solicitarDespegar() {
        System.out.println("[" + codigoVuelo + "] Avión de Carga solicita autorización para despegar.");
        torre.solicitarDespegue(this);
    }

    @Override
    public void recibirMensaje(String mensaje) {
        System.out.println("[" + codigoVuelo + "] Mensaje de la torre recibido: " + mensaje);
    }
}
