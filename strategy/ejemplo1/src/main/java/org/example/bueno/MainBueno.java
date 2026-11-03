package org.example.bueno;


import org.example.bueno.context.Navegador;
import org.example.bueno.strategies.RutaCarreteraStrategy;
import org.example.bueno.strategies.RutaPeatonalStrategy;
import org.example.bueno.strategies.RutaTransportePublicoStrategy;

public class MainBueno {

    public static void main(String[] args) {

        // Inicializamos el navegador con la estrategia de coche
        Navegador navegador = new Navegador(new RutaCarreteraStrategy());
        navegador.construirRuta("Plaza Central", "Aeropuerto");


        // Cambiamos dinámicamente a la estrategia peatonal
        navegador.setEstrategia(new RutaPeatonalStrategy());
        navegador.construirRuta("Plaza Central", "Museo de Arte");


        // Cambiamos dinámicamente a transporte público
        navegador.setEstrategia(new RutaTransportePublicoStrategy());
        navegador.construirRuta("Estación de Tren", "Universidad");

    }
}
