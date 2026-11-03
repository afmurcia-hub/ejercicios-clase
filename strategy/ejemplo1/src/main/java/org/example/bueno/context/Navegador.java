package org.example.bueno.context;


import org.example.bueno.strategies.RutaStrategy;

public class Navegador {

    private RutaStrategy estrategia;

    // Constructor opcional para inicializar con una estrategia
    public Navegador(RutaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    // Permite cambiar de estrategia dinámicamente en tiempo de ejecución
    public void setEstrategia(RutaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void construirRuta(String origen, String destino) {
        if (estrategia == null) {
            throw new IllegalStateException("No se ha seleccionado ninguna estrategia de enrutamiento.");
        }
        // Delegación del algoritmo a la estrategia vinculada
        estrategia.crearRuta(origen, destino);
    }
}
