package org.example.colegas;

public class SistemaNotificaciones extends ComponenteAeropuerto {
    @Override
    public void ejecutarAccion(String accion, String idVuelo) {
        if (accion.equals("ENVIAR_SMS_EQUIPAJE")) {
            System.out.println("[SistemaNotificaciones] Enviando SMS: 'Su equipaje del vuelo " + idVuelo + " está disponible'.");
        } else if (accion.equals("ALERTA_GENERAL")) {
            System.out.println("[SistemaNotificaciones] ANUNCIO EN ALTAVOCES: Alerta de emergencia en pista por vuelo " + idVuelo);
        }
    }
}
