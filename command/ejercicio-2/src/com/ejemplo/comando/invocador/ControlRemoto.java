package com.ejemplo.comando.invocador;

import com.ejemplo.comando.core.Comando;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Invocador: Administra la ejecución de comandos y mantiene la pila de historial para deshacer.
 */
public class ControlRemoto {

    private Stack<Comando> historial = new Stack<>();


    public void ejecutarComando(Comando comando) {
        if (comando != null) {
            comando.ejecutar();
            historial.push(comando);
        }
    }

    public boolean deshacer() {
        if (!historial.isEmpty()) {
            Comando ultimoComando = historial.pop();
            ultimoComando.deshacer();
            return true;
        }
        return false;
    }

    public List<String> obtenerNombresHistorial() {
        List<String> nombres = new ArrayList<>();
        for (Comando cmd : historial) {
            nombres.add(cmd.obtenerNombre());
        }
        return nombres;
    }
}
