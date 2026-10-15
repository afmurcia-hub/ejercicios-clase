package org.example;

public class ConAnilloMagico extends EquipamientoDecorator {

    public ConAnilloMagico(Personaje personaje) {
        super(personaje); // Pasa el personaje a la clase abstracta decoradora
    }

    @Override
    public String getDescripcion() {
        // Concatenamos la descripción anterior con el nuevo accesorio
        return personaje.getDescripcion() + " con Anillo Mágico";
    }

    @Override
    public int getAtaque() {
        // Sumamos el poder del personaje previo más el bono del anillo mágico
        return personaje.getAtaque() + 10;
    }
}
