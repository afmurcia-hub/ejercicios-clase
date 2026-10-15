package org.example.fachada;


import org.example.modelo.ReporteDestino;
import org.example.subsistemas.RepositorioHistorialNeon;
import org.example.subsistemas.ServicioClimaApi;
import org.example.subsistemas.ServicioPaisApi;

public class FachadaInformacionDestino {

    private final ServicioPaisApi servicioPais;
    private final ServicioClimaApi servicioClima;
    private final RepositorioHistorialNeon repositorioNeon;

    public FachadaInformacionDestino() {
        this.servicioPais = new ServicioPaisApi();
        this.servicioClima = new ServicioClimaApi();
        this.repositorioNeon = new RepositorioHistorialNeon();
    }

    // Recibe los datos del cliente y el país solicitado
    public ReporteDestino consultarDestino(String cedulaCliente, String nombreCliente, String nombrePais) {

        System.out.println("\n[Fachada] Atendiendo a " + nombreCliente + " para destino: " + nombrePais);

        try {
            // 1. Consulta API 1 (RestCountries) -> no requiere saber quién es el cliente
            ServicioPaisApi.DatosPais datosPais = servicioPais.obtenerDatosPais(nombrePais);

            // 2. Consulta API 2 (Open-Meteo) -> solo requiere coordenadas
            double temperatura = servicioClima.obtenerTemperaturaActual(datosPais.latitud, datosPais.longitud);

            // 3. Persiste en Neon vinculando la consulta al cliente para analítica
            repositorioNeon.registrarConsulta(
                    cedulaCliente,
                    nombreCliente,
                    nombrePais,
                    datosPais.capital,
                    temperatura,
                    datosPais.moneda
            );

            // 4. Retorna el resultado consolidado
            return new ReporteDestino(nombrePais, datosPais.capital, temperatura, datosPais.moneda);

        } catch (Exception e) {
            System.err.println("[Fachada] Error durante la orquestación: " + e.getMessage());
            return null;
        }
    }
}