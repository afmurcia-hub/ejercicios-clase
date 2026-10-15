package org.example;

public class GuerreroBasico implements Personaje {

    @Override public String getDescripcion() {
        return "Guerrero Básico";
    }

    @Override public int getAtaque() {
        return 10;
    }
}
