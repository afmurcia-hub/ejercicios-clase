package org.example;

public abstract class EquipamientoDecorator implements Personaje {
    protected Personaje personaje;

    public EquipamientoDecorator(Personaje personaje) {
        this.personaje = personaje; }

    @Override public String getDescripcion() {
        return personaje.getDescripcion();
    }

    @Override public int getAtaque() {
        return personaje.getAtaque();
    }
}
