package org.example.bueno.strategies;

public class RutaCarreteraStrategy implements RutaStrategy {
    @Override
    public void crearRuta(String origen, String destino) {
        System.out.println(" Ruta en COCHE: evaluando tráfico de autopistas desde " + origen + " hasta " + destino);
    }
}
