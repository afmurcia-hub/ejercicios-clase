package org.example.subscribers;


import org.example.interfaces.Observador;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SistemaAuditoriaLog implements Observador {
    @Override
    public void actualizar(String nombreProducto, double nuevoPrecio) {
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(" [LOG " + hora + "]: Cambio de precio registrado en BD para '"
                + nombreProducto + "' -> $" + nuevoPrecio);
    }
}