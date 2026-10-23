package org.example.publisher;

import org.example.interfaces.ObservadorCripto;
import org.example.model.CotizacionReal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MonitorBinanceReal {
    private final String simbolo;
    private double ultimoPrecio = 0.0;

    // Lista del patrón Observer
    private final List<ObservadorCripto> observadores = new ArrayList<>();

    // Cliente Java para conectarse a internet
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public MonitorBinanceReal(String simbolo) {
        this.simbolo = simbolo;
    }

    public void suscribir(ObservadorCripto obs) {
        observadores.add(obs);
    }

    public void desuscribir(ObservadorCripto obs) {
        observadores.remove(obs);
    }

    public void consultarApiEnVivo() {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol=" + simbolo;

        try {
            // 1. Preparamos y enviamos la petición a la URL de Binance
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // 2. Si el servidor de Binance respondió "200 OK"
            if (response.statusCode() == 200) {
                double precioRecibido = extraerPrecioSimple(response.body());

                // Primera lectura al arrancar el programa: solo guardamos el precio base
                if (ultimoPrecio == 0.0) {
                    ultimoPrecio = precioRecibido;
                    System.out.printf(" [BINANCE API] Precio inicial de %s: $%,.2f USD%n%n", simbolo, ultimoPrecio);
                    return;
                }

                // 3. EL PATRÓN OBSERVER: ¿Cambió el precio respecto a hace 3 segundos?
                if (precioRecibido != ultimoPrecio) {
                    double diferencia = precioRecibido - ultimoPrecio;

                    CotizacionReal evento = new CotizacionReal(
                            simbolo, ultimoPrecio, precioRecibido, diferencia, LocalTime.now()
                    );

                    ultimoPrecio = precioRecibido; // Guardamos el nuevo precio para la próxima vuelta
                    notificarObservadores(evento); // DISPARA EL PATRÓN OBSERVER
                } else {
                    System.out.println(" [SIN CAMBIOS] " + simbolo + " se mantiene en $" + ultimoPrecio);
                }
            }
        } catch (Exception e) {
            System.err.println(" Error de conexión: " + e.getMessage());
        }
    }








    private void notificarObservadores(CotizacionReal cotizacion) {
        for (ObservadorCripto obs : observadores) {
            obs.actualizar(cotizacion);
        }
    }

    // Metodo para sacar el precio del texto JSON: {"symbol":"BTCUSDT","price":"68450.12"}
    private double extraerPrecioSimple(String json) {
        String[] partes = json.split("\"");
        String textoPrecio = partes[7];
        return Double.parseDouble(textoPrecio);
    }
}