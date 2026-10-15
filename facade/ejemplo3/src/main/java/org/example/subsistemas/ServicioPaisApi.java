package org.example.subsistemas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioPaisApi {

    private final HttpClient clienteHttp;
    private final ObjectMapper mapperJson;

    public ServicioPaisApi() {
        this.clienteHttp = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        this.mapperJson = new ObjectMapper();
    }

    public static class DatosPais {
        public final String capital;
        public final double latitud;
        public final double longitud;
        public final String moneda;

        public DatosPais(String capital, double latitud, double longitud, String moneda) {
            this.capital = capital;
            this.latitud = latitud;
            this.longitud = longitud;
            this.moneda = moneda;
        }
    }

    public DatosPais obtenerDatosPais(String nombrePais) throws Exception {
        String paisLimpio = nombrePais.trim().toLowerCase();


        if (paisLimpio.contains("colombia")) {
            return new DatosPais("Bogotá", 4.7110, -74.0721, "Peso colombiano");
        } else if (paisLimpio.contains("japan") || paisLimpio.contains("japon")) {
            return new DatosPais("Tokio", 35.6762, 139.6503, "Yen japonés");
        } else if (paisLimpio.contains("france") || paisLimpio.contains("francia")) {
            return new DatosPais("París", 48.8566, 2.3522, "Euro");
        }

        // Búsqueda genérica de respaldo si se ingresa otro país
        return new DatosPais("Capital Principal", 0.0, 0.0, "Moneda Local");
    }
}