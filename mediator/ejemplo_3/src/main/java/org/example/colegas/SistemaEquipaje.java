package org.example.colegas;

import org.example.eventos.EventoVuelo;
import org.example.eventos.TipoEvento;

public class SistemaEquipaje extends ComponenteAeropuerto {
    @Override
    public void ejecutarAccion(String accion, String idVuelo) {
        if (accion.equals("INICIAR_DESCARGA")) {
            System.out.println("[SistemaEquipaje] Descargando maletas del vuelo " + idVuelo);
            // Simula que el equipaje terminó y avisa de vuelta al mediador
            mediador.notificar(new EventoVuelo(TipoEvento.EQUIPAJE_DESCARGADO, idVuelo, "Maletas en banda 4"));
        }
    }
}
