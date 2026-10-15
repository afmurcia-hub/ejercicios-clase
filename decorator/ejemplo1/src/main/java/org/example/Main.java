package org.example;

import org.example.base.Notificador;
import org.example.tipo.NotificadorEmail;
import org.example.tipo.NotificadorSMS;
import org.example.tipo.NotificadorSimple;

public class Main {
    public static void main(String[] args) {


        Notificador notificador = new NotificadorSimple();

        Notificador notificadorConEmail = new NotificadorEmail(notificador);

        Notificador notificadorConSMS = new NotificadorSMS(notificadorConEmail);

        notificadorConSMS.enviar("Tu pedido ha sido enviado");


    }
}