package com.ejemplo.comando.servidor;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import com.ejemplo.comando.receptor.Luz;
import com.ejemplo.comando.invocador.ControlRemoto;
import com.ejemplo.comando.comandos.ComandoEncenderLuz;
import com.ejemplo.comando.comandos.ComandoApagarLuz;

import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.nio.file.Files;
import java.net.InetSocketAddress;

/**
 * Servidor Web REST nativo de Java.
 * Proporciona endpoints
 */
public class ServidorWeb {

    private static Luz luz = new Luz("Salón Principal");

    private static ControlRemoto controlRemoto = new ControlRemoto();

    public static void main(String[] args) throws IOException {

        int puerto = 8080;

        HttpServer servidor = HttpServer.create(new InetSocketAddress(puerto), 0);


        servidor.createContext("/api/encender", intercambio -> {
            controlRemoto.ejecutarComando(new ComandoEncenderLuz(luz));
            responderJson(intercambio);
        });

        servidor.createContext("/api/apagar", intercambio -> {
            controlRemoto.ejecutarComando(new ComandoApagarLuz(luz));
            responderJson(intercambio);
        });

        servidor.createContext("/api/deshacer", intercambio -> {
            controlRemoto.deshacer();
            responderJson(intercambio);
        });

        servidor.createContext("/api/estado", intercambio -> responderJson(intercambio));

        servidor.createContext("/", intercambio -> {
            File archivo = new File("public/index.html");
            if (!archivo.exists()) archivo = new File("index.html");
            byte[] bytesArchivo = Files.readAllBytes(archivo.toPath());
            intercambio.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            intercambio.sendResponseHeaders(200, bytesArchivo.length);
            try (OutputStream flujoSalida = intercambio.getResponseBody()) {
                flujoSalida.write(bytesArchivo);
            }
        });

        servidor.start();
        System.out.println(" Servidor Java iniciado en: http://localhost:" + puerto);
    }

    private static void responderJson(HttpExchange intercambio) throws IOException {
        StringBuilder historialJson = new StringBuilder("[");
        var historial = controlRemoto.obtenerNombresHistorial();
        for (int i = 0; i < historial.size(); i++) {
            historialJson.append("\"").append(historial.get(i)).append("\"");
            if (i < historial.size() - 1) {
                historialJson.append(",");
            }
        }
        historialJson.append("]");

        String jsonRespuesta = String.format(
            "{\"encendida\": %b, \"ubicacion\": \"%s\", \"historial\": %s}",
            luz.estaEncendida(), luz.obtenerUbicacion(), historialJson.toString()
        );

        byte[] respuestaBytes = jsonRespuesta.getBytes("UTF-8");
        intercambio.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        intercambio.sendResponseHeaders(200, respuestaBytes.length);
        try (OutputStream flujoSalida = intercambio.getResponseBody()) {
            flujoSalida.write(respuestaBytes);
        }
    }
}
