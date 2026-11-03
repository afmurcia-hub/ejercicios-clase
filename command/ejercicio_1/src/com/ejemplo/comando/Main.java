package com.ejemplo.comando;

import com.ejemplo.comando.core.Comando;
import com.ejemplo.comando.receptor.Luz;
import com.ejemplo.comando.comandos.ComandoEncenderLuz;
import com.ejemplo.comando.comandos.ComandoApagarLuz;
import com.ejemplo.comando.invocador.ControlRemoto;

import java.util.Scanner;

/**
 * Cliente : Configura los objetos y actúa como punto de entrada
 */
public class Main {

    public static void main(String[] args) {

        Scanner escaner = new Scanner(System.in);

        // 1. Instanciar el receptor (Lógica real del dispositivo)
        Luz luzSalon = new Luz("Salón Principal");

        // 2. Instanciar los comandos concretos vinculados a la luz
        Comando encender = new ComandoEncenderLuz(luzSalon);
        Comando apagar = new ComandoApagarLuz(luzSalon);

        // 3. Instanciar el invocador (Control remoto)
        ControlRemoto controlRemoto = new ControlRemoto();

        int opcion = 0;

        System.out.println("==================================================");
        System.out.println("  DEMOSTRACIÓN DEL PATRÓN COMANDO (CONSOLA JAVA)  ");
        System.out.println("==================================================");

        while (opcion != 6) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Presionar Botón: Encender Luz");
            System.out.println("2. Presionar Botón: Apagar Luz");
            System.out.println("3. Presionar Botón: Deshacer Última Acción (Undo)");
            System.out.println("4. Ver Historial de Comandos Ejecutados");
            System.out.println("5. Ver Estado Actual de la Luz");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (escaner.hasNextInt()) {
                opcion = escaner.nextInt();
                System.out.println();

                switch (opcion) {
                    case 1 -> {
                        controlRemoto.asignarComando(encender);
                        controlRemoto.presionarBoton();
                    }
                    case 2 -> {
                        controlRemoto.asignarComando(apagar);
                        controlRemoto.presionarBoton();
                    }
                    case 3 -> controlRemoto.presionarDeshacer();
                    case 4 -> controlRemoto.mostrarHistorial();
                    case 5 -> {
                        String estadoText = luzSalon.estaEncendida() ? "ENCENDIDA 💡" : "APAGADA 🌑";
                        System.out.println("📍 Ubicación: " + luzSalon.obtenerUbicacion());
                        System.out.println("⚡ Estado: " + estadoText);
                    }
                    case 6 -> System.out.println(" Saliendo del programa...");
                    default -> System.out.println(" Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("⚠️ Por favor ingrese un número entero válido.");
                escaner.next();
            }
        }

        escaner.close();
    }
}
