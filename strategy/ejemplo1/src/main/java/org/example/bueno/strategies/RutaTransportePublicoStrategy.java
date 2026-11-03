package org.example.bueno.strategies;

public class RutaTransportePublicoStrategy implements RutaStrategy {
    @Override
    public void crearRuta(String origen, String destino) {
        System.out.println(" Ruta TRANSPORTE PÚBLICO: consultando horarios de autobús y metro desde " + origen + " hasta " + destino);
    }
}
