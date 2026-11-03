package com.ejemplo.comando.receptor;

/**
 * Receptor : Contiene la lógica real del negocio.
 */
public class Luz {
    private String ubicacion;
    private boolean encendida;

    public Luz(String ubicacion) {
        this.ubicacion = ubicacion;
        this.encendida = false;
    }

    public void encender() {
        this.encendida = true;
    }

    public void apagar() {
        this.encendida = false;
    }

    public boolean estaEncendida() {
        return encendida;
    }

    public String obtenerUbicacion() {
        return ubicacion;
    }
}
