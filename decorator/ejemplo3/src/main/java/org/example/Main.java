package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Un guerrero común (Ataque: 10)
        Personaje heroe = new GuerreroBasico();

        // Le equipamos una espada: Guerrero Básico con Espada (Ataque: 25)
        Personaje heroeConEspada = new ConEspada(heroe);

        // Super combinación: Guerrero con Anillo Mágico Y con Espada (Ataque: 40)
        Personaje heroeLegendario = new ConAnilloMagico(heroeConEspada);

        System.out.println(heroeLegendario.getDescripcion() + " | Poder de Ataque: " + heroeLegendario.getAtaque());

    }
}