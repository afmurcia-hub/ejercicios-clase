package org.example.mediador;

import org.example.colegas.ComponenteAeropuerto;
import org.example.eventos.EventoVuelo;

import java.util.ArrayList;
import java.util.List;

// El mediador  gestiona una lista de subsistemas desacoplados y enruta los eventos
public class TorreControlCentral implements MediadorAeropuerto {

    private final List<ComponenteAeropuerto> subsistemas = new ArrayList<>();

    public void registrarSubsistema(ComponenteAeropuerto subsistema) {
        subsistemas.add(subsistema);
        //el subsistema ya sabe quién es su jefe (el mediador)
        subsistema.setMediador(this);
    }

    @Override
    public synchronized void notificar(EventoVuelo evento) {
        System.out.println("\n[Mediador Central] Evento detectado -> [" + evento.getTipo() + "] para el vuelo " + evento.getIdVuelo() + " (" + evento.getDetalles() + ")");

        // Lógica de orquestación basada en reglas de negocio
        switch (evento.getTipo()) {
            case AVION_ATERRIZADO:
                System.out.println("[Torre] -> El avión tocó pista. Ordenando despliegue de logística...");
                dispararAccionEnSubsistemas("SistemaEquipaje", "INICIAR_DESCARGA", evento.getIdVuelo());
                dispararAccionEnSubsistemas("PasarelaAbordaje", "ACOPLAR_PUERTA", evento.getIdVuelo());
                break;

            case EQUIPAJE_DESCARGADO:
                System.out.println("[Torre] -> Equipaje en banda. Notificando a pasajeros...");
                dispararAccionEnSubsistemas("SistemaNotificaciones", "ENVIAR_SMS_EQUIPAJE", evento.getIdVuelo());
                break;

            case EMERGENCIA_TECNICA:
                System.out.println("[ALERTA CRÍTICA] -> ¡Emergencia recibida! Despejando espacio aéreo para " + evento.getIdVuelo());
                dispararAccionEnSubsistemas("SistemaNotificaciones", "ALERTA_GENERAL", evento.getIdVuelo());
                break;

            default:
                break;
        }
    }

    private void dispararAccionEnSubsistemas(String nombreSubsistema, String accion, String idVuelo) {
        for (ComponenteAeropuerto sub : subsistemas) {
            if (sub.getClass().getSimpleName().equalsIgnoreCase(nombreSubsistema)) {
                sub.ejecutarAccion(accion, idVuelo);
            }
        }
    }
}
