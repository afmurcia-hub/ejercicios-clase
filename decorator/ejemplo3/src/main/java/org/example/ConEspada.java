package org.example;

public class ConEspada extends EquipamientoDecorator {

    public ConEspada(Personaje p) {
        super(p);
    }

    @Override public String getDescripcion() {
        return personaje.getDescripcion() + " con Espada";
    }

    @Override public int getAtaque() {
        return personaje.getAtaque() + 15;
    }
}