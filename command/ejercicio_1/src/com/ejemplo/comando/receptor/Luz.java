package com.ejemplo.comando.receptor;

/**
 * Receptor: Contiene la lógica real
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
        System.out.println("💡 [" + ubicacion + "] La luz se ha ENCENDIDO.");
    }

    public void apagar() {
        this.encendida = false;
        System.out.println("🌑 [" + ubicacion + "] La luz se ha APAGADO.");
    }

    public boolean estaEncendida() {
        return encendida;
    }

    public String obtenerUbicacion() {
        return ubicacion;
    }
}
