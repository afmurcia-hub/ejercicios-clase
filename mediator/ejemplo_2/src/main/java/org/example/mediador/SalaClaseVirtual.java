package org.example.mediador;

import org.example.colegas.Profesor;
import org.example.colegas.Usuario;

import java.util.ArrayList;
import java.util.List;

public class SalaClaseVirtual implements MediadorChat {

    // EL MEDIADOR CONOCE A TODOS LOS COLEGAS (La lista central)
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private boolean claseSilenciada = false;

    @Override
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("[SalaVirtual] " + usuario.getNombre() + " se ha unido a la clase.");
    }

    @Override
    public void enviarMensajeGeneral(String mensaje, Usuario emisor) {
        // Regla: Si la clase está silenciada, solo el profesor puede hablar
        if (claseSilenciada && !(emisor instanceof Profesor)) {
            System.out.println("[Sistema] El estudiante " + emisor.getNombre() + " no puede hablar. La clase está silenciada por el profesor.");
            return;
        }

        System.out.println("\n[Chat General] " + emisor.getNombre() + " dice: " + mensaje);

        // El mediador recorre la lista y reparte el mensaje a todos MENOS al emisor
        for (Usuario usuario : listaUsuarios) {
            if (usuario != emisor) {
                usuario.recibirMensaje(mensaje, emisor.getNombre());
            }
        }
    }

    @Override
    public void enviarMensajePrivado(String mensaje, Usuario emisor, String nombreReceptor) {
        System.out.println("\n[Chat Privado] " + emisor.getNombre() + " para " + nombreReceptor + ": " + mensaje);

        boolean encontrado = false;
        // El mediador busca en su lista al destinatario específico
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombreReceptor)) {
                usuario.recibirMensaje("(Privado) " + mensaje, emisor.getNombre());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("[Sistema] Usuario '" + nombreReceptor + "' no encontrado en la sala.");
        }
    }

    @Override
    public void alternarSilencioGlobal(Usuario emisor) {
        if (emisor instanceof Profesor) {
            claseSilenciada = !claseSilenciada;
            String estado = claseSilenciada ? "SILENCIADA (Solo el profe habla)" : "HABILITADA (Todos pueden hablar)";
            System.out.println("[Sistema] La sala de clases ahora está: " + estado);
        } else {
            System.out.println("[Sistema] Solo un profesor puede silenciar la clase.");
        }
    }
}
