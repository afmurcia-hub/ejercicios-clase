package org.example.subsistemas;

// API o Servicio de Logística / Despachos
public class ServicioLogistica {

    public String generarGuiaEnvio(String direccion, String idProducto) {
        System.out.println("Generando guía de envío hacia: " + direccion);
        return "GUIA-98234-XYZ";
    }
}