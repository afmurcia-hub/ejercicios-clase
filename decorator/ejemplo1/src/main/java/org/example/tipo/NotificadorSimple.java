package org.example.tipo;


import org.example.base.Notificador;

public class NotificadorSimple implements Notificador {

    @Override
    public void enviar(String mensaje) {
        System.out.println("Notificación básica: " + mensaje);
    }
}
