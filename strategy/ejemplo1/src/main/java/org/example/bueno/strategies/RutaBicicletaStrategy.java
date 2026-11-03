package org.example.bueno.strategies;

public class RutaBicicletaStrategy implements RutaStrategy {

    @Override
    public void crearRuta(String origen, String destino) {
        System.out.println(" Ruta BICICLETA: priorizando ciclovías y vías seguras desde " + origen + " hasta " + destino);
    }
}
