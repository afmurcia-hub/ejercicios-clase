package org.example;

import java.util.ArrayList;
import java.util.List;

public class TorreControl implements TorreControlMediator {

    private List<Avion> avionesRegistrados = new ArrayList<>();
    private boolean pistaDisponible = true;

    @Override
    public void registrarAvion(Avion avion) {
        avionesRegistrados.add(avion);
    }

    @Override
    public void solicitarAterrizaje(Avion avion) {
        if (pistaDisponible) {
            System.out.println("TORRE CONTROL: Pista libre. Permiso concedido a " + avion.getCodigoVuelo() + " para aterrizar.");
            pistaDisponible = false;
            notificarOtrosAviones(avion, "El avión " + avion.getCodigoVuelo() + " está aterrizando. Mantengan su altitud.");
        } else {
            System.out.println("TORRE CONTROL: Pista ocupada. " + avion.getCodigoVuelo() + " debe permanecer en patrón de espera.");
        }
    }

    @Override
    public void solicitarDespegue(Avion avion) {
        if (pistaDisponible) {
            System.out.println("TORRE CONTROL: Permiso concedido a " + avion.getCodigoVuelo() + " para despegar.");
            pistaDisponible = true;
        } else {
            System.out.println("TORRE CONTROL: Espere, la pista está ocupada.");
        }
    }

    private void notificarOtrosAviones(Avion emisor, String mensaje) {
        for (Avion a : avionesRegistrados) {
            if (a != emisor) {
                a.recibirMensaje(mensaje);
            }
        }
    }
}
