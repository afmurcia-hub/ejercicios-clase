package com.ejemplo.comando.servidor;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.ejemplo.comando.receptor.Luz;
import com.ejemplo.comando.invocador.ControlRemoto;
import com.ejemplo.comando.comandos.ComandoEncenderLuz;
import com.ejemplo.comando.comandos.ComandoApagarLuz;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ServidorWeb {

    private static Luz luz = new Luz("Salón Principal");
    private static ControlRemoto controlRemoto = new ControlRemoto();

    public static void main(String[] args) throws IOException {
        int puerto = 8080;
        HttpServer servidor = HttpServer.create(new InetSocketAddress(puerto), 0);

        servidor.createContext("/api/encender", intercambio -> {
            agregarCabecerasCors(intercambio);
            if ("OPTIONS".equals(intercambio.getRequestMethod())) { intercambio.sendResponseHeaders(204, -1); return; }
            controlRemoto.ejecutarComando(new ComandoEncenderLuz(luz));
            responderJson(intercambio);
        });

        servidor.createContext("/api/apagar", intercambio -> {
            agregarCabecerasCors(intercambio);
            if ("OPTIONS".equals(intercambio.getRequestMethod())) { intercambio.sendResponseHeaders(204, -1); return; }
            controlRemoto.ejecutarComando(new ComandoApagarLuz(luz));
            responderJson(intercambio);
        });

        servidor.createContext("/api/deshacer", intercambio -> {
            agregarCabecerasCors(intercambio);
            if ("OPTIONS".equals(intercambio.getRequestMethod())) { intercambio.sendResponseHeaders(204, -1); return; }
            controlRemoto.deshacer();
            responderJson(intercambio);
        });

        servidor.createContext("/api/estado", intercambio -> {
            agregarCabecerasCors(intercambio);
            if ("OPTIONS".equals(intercambio.getRequestMethod())) { intercambio.sendResponseHeaders(204, -1); return; }
            responderJson(intercambio);
        });

        servidor.start();
        System.out.println(" Backend Java API iniciado en: http://localhost:" + puerto);
    }

    private static void agregarCabecerasCors(HttpExchange intercambio) {
        intercambio.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        intercambio.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        intercambio.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
    }

    private static void responderJson(HttpExchange intercambio) throws IOException {
        StringBuilder historialJson = new StringBuilder("[");
        var historial = controlRemoto.obtenerNombresHistorial();
        for (int i = 0; i < historial.size(); i++) {
            historialJson.append("\"").append(historial.get(i)).append("\"");
            if (i < historial.size() - 1) historialJson.append(",");
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


/*
@RestController
@RequestMapping("/api")
public class LuzController {

    @PostMapping("/encender")
    public Luz encenderLuz() {
        controlRemoto.ejecutarComando(new ComandoEncenderLuz(luz));
        return luz; // Spring lo convierte a JSON automáticamente y maneja el HTTP 200
    }
}
 */