package org.example;

public class CafeSimple implements Bebida {

    @Override
    public String getDescripcion() {
        return "Café básico";
    }

    @Override
    public double getCosto() {
        return 5000;
    }
}
