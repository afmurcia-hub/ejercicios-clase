package org.example.colegas;

import org.example.mediador.MediadorChat;

public class Profesor extends Usuario {

    public Profesor(MediadorChat mediador, String nombre) {
        super(mediador, nombre);
    }

    // El profesor tiene permisos especiales de nivel intermedio: puede silenciar la clase
    public void cambiarModoSilencio() {
        System.out.println("\n[!] El profesor " + nombre + " ha alterado el estado de silencio de la clase.");
        mediador.alternarSilencioGlobal(this);
    }

    @Override
    public void recibirMensaje(String mensaje, String emisor) {
        System.out.println("[Profesor " + nombre + "] Mensaje de " + emisor + ": " + mensaje);
    }
}
