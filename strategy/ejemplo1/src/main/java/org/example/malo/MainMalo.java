package org.example.malo;

public class MainMalo {
    public static void main(String[] args) {
        NavegadorMalo navegador = new NavegadorMalo();

        navegador.crearRuta("Centro", "Aeropuerto", TipoTransporte.COCHE);
        navegador.crearRuta("Centro", "Parque", TipoTransporte.PEATON);
    }
}
