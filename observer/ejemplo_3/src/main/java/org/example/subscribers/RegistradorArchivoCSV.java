package org.example.subscribers;

import org.example.interfaces.ObservadorCripto;
import org.example.model.CotizacionReal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistradorArchivoCSV implements ObservadorCripto {
    private final String rutaArchivo;

    public RegistradorArchivoCSV(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void actualizar(CotizacionReal c) {

        try (PrintWriter out = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            out.printf("%s,%s,%.2f,%.2f,%.2f%n",
                    c.horaLectura(), c.simbolo(), c.precioAnterior(), c.precioActual(), c.diferenciaUsd());
            System.out.println("  [CSV]: Guardado en disco en '" + rutaArchivo + "'");
        } catch (IOException e) {
            System.err.println("Error escribiendo CSV: " + e.getMessage());
        }
    }
}