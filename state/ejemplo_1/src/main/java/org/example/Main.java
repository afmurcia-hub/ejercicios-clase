package org.example;


import org.example.context.Reproductor;

public class Main {
    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();

        System.out.println("--- Intentar pausar estando detenido ---");
        reproductor.pausar();

        System.out.println("\n--- Iniciar reproducción ---");
        reproductor.reproducir();

        System.out.println("\n--- Pausar ---");
        reproductor.pausar();

        System.out.println("\n--- Reanudar ---");
        reproductor.reproducir();

        System.out.println("\n--- Detener ---");
        reproductor.detener();

    }
}