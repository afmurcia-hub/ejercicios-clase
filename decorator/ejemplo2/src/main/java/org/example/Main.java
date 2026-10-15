package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Pedimos un café simple
        Bebida miCafe = new CafeSimple();
        System.out.println(miCafe.getDescripcion() + " -> $" + miCafe.getCosto());

        // 2. Queremos el café con leche (envolvemos el café simple)
        Bebida cafeConLeche = new ConLeche(new CafeSimple());
        System.out.println(cafeConLeche.getDescripcion() + " -> $" + cafeConLeche.getCosto());


        // 3. Un pedido complejo: Café con leche Y crema batida (doble decoración)
        Bebida cafeCompleto = new ConCremaBatida(new ConLeche(new CafeSimple()));
        System.out.println(cafeCompleto.getDescripcion() + " -> $" + cafeCompleto.getCosto());

    }
}