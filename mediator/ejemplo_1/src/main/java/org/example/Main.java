package org.example;

public class Main {
    public static void main(String[] args) {
        TorreControlMediator torre = new TorreControl();

        AvionComercial vueloIberia = new AvionComercial(torre, "IB-502");
        AvionCarga vueloFedex = new AvionCarga(torre, "FDX-99");

        torre.registrarAvion(vueloIberia);
        torre.registrarAvion(vueloFedex);

        // Interacciones de despegue y aterrizaje gestionadas por el Mediador
        vueloIberia.solicitarAterrizar();
        System.out.println("---");
        vueloFedex.solicitarDespegar();
    }
}