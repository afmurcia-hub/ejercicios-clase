package org.example.malo;

public class NavegadorMalo {

    // Metodo con un bloque condicional masivo
    public void crearRuta(String origen, String destino, TipoTransporte tipo) {

        if (tipo == TipoTransporte.COCHE) {
            System.out.println(" Calculando ruta por autopistas para coches desde " + origen + " hasta " + destino);
            // Lógica compleja específica para coches...
        } else if (tipo == TipoTransporte.PEATON) {
            System.out.println(" Calculando ruta a pie por aceras y calles desde " + origen + " hasta " + destino);
            // Lógica compleja específica para peatones...
        } else if (tipo == TipoTransporte.TRANSPORTE_PUBLICO) {
            System.out.println(" Calculando ruta combinando metro y autobús desde " + origen + " hasta " + destino);
            // Lógica compleja para transporte público...
        } else if (tipo == TipoTransporte.BICICLETA) {
            System.out.println(" Calculando ruta usando ciclovías desde " + origen + " hasta " + destino);
            // Lógica compleja para bicicletas...
        } else {
            throw new IllegalArgumentException("Tipo de transporte no soportado.");
        }
    }
}