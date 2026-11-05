package org.example.colegas;

public class PasarelaAbordaje extends ComponenteAeropuerto {
    @Override
    public void ejecutarAccion(String accion, String idVuelo) {
        if (accion.equals("ACOPLAR_PUERTA")) {
            System.out.println("[PasarelaAbordaje] Acoplando manga de desembarque al avión " + idVuelo);
        }
    }
}