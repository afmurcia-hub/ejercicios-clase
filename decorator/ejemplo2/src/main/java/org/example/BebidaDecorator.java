package org.example;

public abstract class BebidaDecorator implements Bebida {
    protected Bebida bebidaEnvuelta;

    public BebidaDecorator(Bebida bebidaEnvuelta) {
        this.bebidaEnvuelta = bebidaEnvuelta;
    }

    @Override
    public String getDescripcion() {
        return bebidaEnvuelta.getDescripcion();
    }

    @Override
    public double getCosto() {
        return bebidaEnvuelta.getCosto();
    }
}