package org.example;

import org.example.colegas.AvionComercial;
import org.example.colegas.PasarelaAbordaje;
import org.example.colegas.SistemaEquipaje;
import org.example.colegas.SistemaNotificaciones;
import org.example.mediador.TorreControlCentral;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el Mediador
        TorreControlCentral torreCentral = new TorreControlCentral();

        // 2. Instanciar los Subsistemas (Colegas independientes)
        SistemaEquipaje equipaje = new SistemaEquipaje();
        PasarelaAbordaje pasarela = new PasarelaAbordaje();
        SistemaNotificaciones notificaciones = new SistemaNotificaciones();
        AvionComercial vueloLatam = new AvionComercial("LA-502");

        // 3. Registrar_todo en el mediador
        torreCentral.registrarSubsistema(equipaje);
        torreCentral.registrarSubsistema(pasarela);
        torreCentral.registrarSubsistema(notificaciones);
        torreCentral.registrarSubsistema(vueloLatam);

        System.out.println("================ SIMULACIÓN CON EVENTOS ================");

        // El avión aterriza y dispara el flujo gestionado al 100% por el mediador
        vueloLatam.solicitarAterrizaje();

        System.out.println("\n-------------------------------------------------------------------\n");

        // Simulamos una emergencia en otro vuelo
        AvionComercial vueloAvianca = new AvionComercial("AV-999");
        torreCentral.registrarSubsistema(vueloAvianca);
        vueloAvianca.declararEmergencia();
    }
}