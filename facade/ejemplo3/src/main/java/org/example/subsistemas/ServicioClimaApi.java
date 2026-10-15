package org.example.subsistemas;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class ServicioClimaApi {

    private final HttpClient clienteHttp;
    private final ObjectMapper mapperJson;

    public ServicioClimaApi() {
        this.clienteHttp = HttpClient.newHttpClient();
        this.mapperJson = new ObjectMapper();
    }

    public double obtenerTemperaturaActual(double latitud, double longitud) throws Exception {
        String url = String.format(Locale.US,
                "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current_weather=true",
                latitud, longitud);

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = clienteHttp.send(solicitud, HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() != 200) {
            throw new RuntimeException("Error consultando API de Clima. Código HTTP: " + respuesta.statusCode());
        }

        JsonNode nodoClima = mapperJson.readTree(respuesta.body()).path("current_weather");
        return nodoClima.path("temperature").asDouble();
    }
}
