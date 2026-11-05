package org.example.colegas;

import org.example.mediador.MediadorChat;

public abstract class Usuario {
    protected MediadorChat mediador;
    protected String nombre;

    public Usuario(MediadorChat mediador, String nombre) {
        this.mediador = mediador;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos para enviar mensajes a través del mediador
    public void hablarATodos(String mensaje) {
        mediador.enviarMensajeGeneral(mensaje, this);
    }

    public void hablarPrivado(String mensaje, String nombreReceptor) {
        mediador.enviarMensajePrivado(mensaje, this, nombreReceptor);
    }

    // Metodo que ejecuta el mediador cuando este usuario recibe un mensaje
    public abstract void recibirMensaje(String mensaje, String emisor);
}
