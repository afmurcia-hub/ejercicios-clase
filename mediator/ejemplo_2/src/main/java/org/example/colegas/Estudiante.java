package org.example.colegas;

import org.example.mediador.MediadorChat;

public class Estudiante extends Usuario {

    public Estudiante(MediadorChat mediador, String nombre) {
        super(mediador, nombre);
    }

    @Override
    public void recibirMensaje(String mensaje, String emisor) {
        System.out.println("[Estudiante " + nombre + "] Mensaje de " + emisor + ": " + mensaje);
    }
}