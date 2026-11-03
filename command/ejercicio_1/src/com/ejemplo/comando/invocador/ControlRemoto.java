package com.ejemplo.comando.invocador;

import com.ejemplo.comando.core.Comando;
import java.util.Stack;

/**
 * Invocador : Administra la ejecución de comandos y mantiene la pila para deshacer.
 */
public class ControlRemoto {

    private Comando botonActual;

    private Stack<Comando> historial = new Stack<>();

    public void asignarComando(Comando comando) {
        this.botonActual = comando;
    }

    public void presionarBoton() {
        if (botonActual != null) {
            botonActual.ejecutar();
            historial.push(botonActual);
        } else {
            System.out.println(" No hay ningún comando asignado al botón.");
        }
    }

    public void presionarDeshacer() {
        if (!historial.isEmpty()) {
            Comando ultimoComando = historial.pop();
            System.out.print("↩️ Deshaciendo acción -> ");
            ultimoComando.deshacer();
        } else {
            System.out.println(" No hay acciones en el historial para deshacer.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n --- HISTORIAL DE COMANDOS EN EL CONTROL REMOTO ---");
        if (historial.isEmpty()) {
            System.out.println("(El historial está vacío)");
        } else {
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i).obtenerNombre());
            }
        }
        System.out.println("----------------------------------------------------\n");
    }
}
