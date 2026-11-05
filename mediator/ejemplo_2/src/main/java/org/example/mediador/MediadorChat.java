package org.example.mediador;

import org.example.colegas.Usuario;

public interface MediadorChat {
    void registrarUsuario(Usuario usuario);
    void enviarMensajeGeneral(String mensaje, Usuario emisor);
    void enviarMensajePrivado(String mensaje, Usuario emisor, String nombreReceptor);
    void alternarSilencioGlobal(Usuario emisor);
}
