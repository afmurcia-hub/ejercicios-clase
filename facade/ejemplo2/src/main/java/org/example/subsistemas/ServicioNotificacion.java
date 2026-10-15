package org.example.subsistemas;

// API o Servicio de Notificaciones (Email, SMS, WhatsApp)
public class ServicioNotificacion {

    public void enviarConfirmacion(String correo, String numeroGuia) {
        System.out.println("Enviando correo a " + correo + " con número de guía: " + numeroGuia);
    }

}