package org.example.bueno.strategies;

public class RutaPeatonalStrategy implements RutaStrategy {
    @Override
    public void crearRuta(String origen, String destino) {
        System.out.println(" Ruta PEATONAL: buscando calles peatonales y senderos desde " + origen + " hasta " + destino);
    }
}
