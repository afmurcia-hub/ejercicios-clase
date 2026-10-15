package org.example;

public class ConLeche extends BebidaDecorator {

    public ConLeche(Bebida bebidaEnvuelta) {
        super(bebidaEnvuelta);
    }

    @Override
    public String getDescripcion() {
        return bebidaEnvuelta.getDescripcion() + ", Leche";
    }

    @Override
    public double getCosto() {
        return bebidaEnvuelta.getCosto() + 2000;
    }
}
