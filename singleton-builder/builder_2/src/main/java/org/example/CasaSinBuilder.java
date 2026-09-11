package org.example;

import java.util.Arrays;

public class CasaSinBuilder {

    // Atributos privados y finales (inmutables)
    private  String tipoEstructura;
    private final int numeroPisos;
    private final double area;
    private final String colorPintura;
    private final boolean tienePiscina;
    private final int numeroVentanas;
    private final boolean tieneGaraje;
    private final boolean tieneJardin;
    private final boolean tieneBalcon;
    private final int numeroHabitaciones;
    private final String materialTecho;
    private final String entorno;
    private final String[] caracteristicas;

    // Constructor gigante: exige pasar TODOS los parámetros en un orden estricto
    public CasaSinBuilder(String tipoEstructura, int numeroPisos, double area, String colorPintura,
                          boolean tienePiscina, int numeroVentanas, boolean tieneGaraje, boolean tieneJardin,
                          boolean tieneBalcon, int numeroHabitaciones, String materialTecho, String entorno,
                          String[] caracteristicas) {
        this.tipoEstructura = tipoEstructura;
        this.numeroPisos = numeroPisos;
        this.area = area;
        this.colorPintura = colorPintura;
        this.tienePiscina = tienePiscina;
        this.numeroVentanas = numeroVentanas;
        this.tieneGaraje = tieneGaraje;
        this.tieneJardin = tieneJardin;
        this.tieneBalcon = tieneBalcon;
        this.numeroHabitaciones = numeroHabitaciones;
        this.materialTecho = materialTecho;
        this.entorno = entorno;
        this.caracteristicas = caracteristicas;
    }

    public double calcularCostoTotal() {
        return this.area * 1500.0;
    }

    public void mostrarDetalles() {
        System.out.println("CasaSinBuilder [Estructura=" + tipoEstructura + ", Pisos=" + numeroPisos + "]");
    }

    @Override
    public String toString() {
        return
                "tipoEstructura='" + tipoEstructura + '\'' +
                ", numeroPisos=" + numeroPisos +
                ", area=" + area +
                ", colorPintura='" + colorPintura + '\'' +
                ", tienePiscina=" + tienePiscina +
                ", numeroVentanas=" + numeroVentanas +
                ", tieneGaraje=" + tieneGaraje +
                ", tieneJardin=" + tieneJardin +
                ", tieneBalcon=" + tieneBalcon +
                ", numeroHabitaciones=" + numeroHabitaciones +
                ", materialTecho='" + materialTecho + '\'' +
                ", entorno='" + entorno + '\'' +
                ", caracteristicas=" + Arrays.toString(caracteristicas) +
                '}';
    }
}
