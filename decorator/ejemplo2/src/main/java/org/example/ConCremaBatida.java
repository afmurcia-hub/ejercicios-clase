package org.example;

public class ConCremaBatida extends BebidaDecorator {

    public ConCremaBatida(Bebida bebidaEnvuelta) {
        super(bebidaEnvuelta);
    }

    @Override
    public String getDescripcion() {
        return bebidaEnvuelta.getDescripcion() + ", Crema Batida";
    }

    @Override
    public double getCosto() {
        return bebidaEnvuelta.getCosto() + 1000;
    }
}
