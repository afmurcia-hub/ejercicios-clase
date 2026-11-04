package org.example.contexto;

import org.example.estado.EstadoClima;
import org.example.estado.EstadoDespejado;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class SistemaRiego {

    private EstadoClima estado;
    private final HttpClient httpClient;

    public SistemaRiego() {
        this.estado = new EstadoDespejado(); // Estado inicial
        this.httpClient = HttpClient.newHttpClient();
    }

    public void setEstado(EstadoClima estado) {
        this.estado = estado;
    }

    // consultar cualquier ubicación por coordenadas
    public void monitorearUbicacion(String nombreLugar, double latitud, double longitud) {
        try {

            String urlApi = "https://api.open-meteo.com/v1/forecast?latitude="
                    + latitud + "&longitude=" + longitud + "&current_weather=true";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();


            double temperatura = extraerValorJson(json, "temperature");
            double velocidadViento = extraerValorJson(json, "windspeed");
            int codigoClima = (int) extraerValorJson(json, "weathercode");

            System.out.println("\n==================================================");
            System.out.println("MONITOREANDO: " + nombreLugar.toUpperCase());
            System.out.println("--------------------------------------------------");
            System.out.println("Temperatura: " + temperatura + " °C | Viento: " + velocidadViento + " km/h | Código Clima: " + codigoClima);

            // El patrón State evalúa el clima del lugar y decide si cambia de estado
            estado.evaluarCambioEstado(this, temperatura, velocidadViento, codigoClima);

            // Ejecuta la acción correspondiente al estado resultante
            estado.ejecutarAccionRiego(this);

        } catch (Exception e) {
            System.err.println("Error al consultar el clima en " + nombreLugar + ": " + e.getMessage());
        }
    }

    private double extraerValorJson(String json, String clave) {
        int posBloque = json.indexOf("\"current_weather\":");
        if (posBloque == -1) return 0.0;

        String subJson = json.substring(posBloque);
        String patron = "\"" + clave + "\":";
        int inicio = subJson.indexOf(patron);
        if (inicio == -1) return 0.0;

        inicio += patron.length();
        int fin = subJson.indexOf(",", inicio);
        if (fin == -1) fin = subJson.indexOf("}", inicio);

        String valorLimpio = subJson.substring(inicio, fin).replaceAll("[^0-9.-]", "").trim();
        return Double.parseDouble(valorLimpio);
    }
}