package org.example.colegas;

import org.example.mediador.MediadorAeropuerto;

public abstract class ComponenteAeropuerto {
    protected MediadorAeropuerto mediador;

    public void setMediador(MediadorAeropuerto mediador) {
        this.mediador = mediador;
    }

    public abstract void ejecutarAccion(String accion, String idVuelo);
}
