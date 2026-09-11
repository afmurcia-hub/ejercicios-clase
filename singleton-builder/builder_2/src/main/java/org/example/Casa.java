package org.example;

import java.util.Arrays;

public class Casa {

    // Atributos privados y finales (inmutables: no cambian una vez construida la casa)
    private final String tipoEstructura;
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

    // Constructor privado: solo el Builder puede usarlo para entregar la casa lista
    private Casa(Builder builder) {
        this.tipoEstructura = builder.tipoEstructura;
        this.numeroPisos = builder.numeroPisos;
        this.area = builder.area;
        this.colorPintura = builder.colorPintura;
        this.tienePiscina = builder.tienePiscina;
        this.numeroVentanas = builder.numeroVentanas;
        this.tieneGaraje = builder.tieneGaraje;
        this.tieneJardin = builder.tieneJardin;
        this.tieneBalcon = builder.tieneBalcon;
        this.numeroHabitaciones = builder.numeroHabitaciones;
        this.materialTecho = builder.materialTecho;
        this.entorno = builder.entorno;
        this.caracteristicas = builder.caracteristicas;
    }


    // Clase interna encargada de armar la casa paso a paso de forma flexible
    public static class Builder {

        // Aquí los atributos SÍ son mutables mientras se configuran
        private String tipoEstructura;
        private int numeroPisos;
        private double area;
        private String colorPintura;
        private boolean tienePiscina;
        private int numeroVentanas;
        private boolean tieneGaraje;
        private boolean tieneJardin;
        private boolean tieneBalcon;
        private int numeroHabitaciones;
        private String materialTecho;
        private String entorno;
        private String[] caracteristicas;






        // Métodos de encadenamiento (Method Chaining): guardan el valor y retornan 'this'
        public Builder tipoEstructura(String tipoEstructura) {
            this.tipoEstructura = tipoEstructura;
            return this;
        }



        public Builder numeroPisos(int numeroPisos) {
            this.numeroPisos = numeroPisos;
            return this;
        }

        public Builder area(double area) {
            this.area = area;
            return this;
        }

        public Builder colorPintura(String colorPintura) {
            this.colorPintura = colorPintura;
            return this;
        }

        public Builder tienePiscina(boolean tienePiscina) {
            this.tienePiscina = tienePiscina;
            return this;
        }

        public Builder numeroVentanas(int numeroVentanas) {
            this.numeroVentanas = numeroVentanas;
            return this;
        }

        public Builder tieneGaraje(boolean tieneGaraje) {
            this.tieneGaraje = tieneGaraje;
            return this;
        }

        public Builder tieneJardin(boolean tieneJardin) {
            this.tieneJardin = tieneJardin;
            return this;
        }

        public Builder tieneBalcon(boolean tieneBalcon) {
            this.tieneBalcon = tieneBalcon;
            return this;
        }

        public Builder numeroHabitaciones(int numeroHabitaciones) {
            this.numeroHabitaciones = numeroHabitaciones;
            return this;
        }

        public Builder materialTecho(String materialTecho) {
            this.materialTecho = materialTecho;
            return this;
        }

        public Builder entorno(String entorno) {
            this.entorno = entorno;
            return this;
        }

        public Builder caracteristicas(String[] caracteristicas) {
            this.caracteristicas = caracteristicas;
            return this;
        }

        // Paso final: empaqueta los datos y entrega el objeto Casa definitivo
        public Casa build() {
            return new Casa(this);
        }
    }

    // Métodos propios del diagrama UML
    public double calcularCostoTotal() {
        // Lógica de cálculo basada en el área y características
        return this.area * 1500.0;
    }

    public void mostrarDetalles() {
        System.out.println("Casa [Estructura=" + tipoEstructura + ", Pisos=" + numeroPisos + ", Área=" + area + "m²]");
    }

    @Override
    public String toString() {
        return "Casa{" +
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