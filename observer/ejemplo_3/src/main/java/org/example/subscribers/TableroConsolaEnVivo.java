package org.example.subscribers;

import org.example.interfaces.ObservadorCripto;
import org.example.model.CotizacionReal;
import java.time.format.DateTimeFormatter;

public class TableroConsolaEnVivo implements ObservadorCripto {

    @Override
    public void actualizar(CotizacionReal c) {
        String hora = c.horaLectura().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String indicador;
        if (c.diferenciaUsd() > 0) {
            indicador = "🟢 SUBIÓ";
        } else {
            indicador = "🔴 BAJÓ";
        }

        System.out.printf("[%s] %s %s -> Nuevo: $%,.2f USD (Variación: %+,.2f USD)%n",
                hora, indicador, c.simbolo(), c.precioActual(), c.diferenciaUsd());
    }
}