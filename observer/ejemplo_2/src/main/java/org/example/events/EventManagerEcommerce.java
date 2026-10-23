package org.example.events;

import org.example.model.DatosEventoPedido;
import org.example.model.TipoEventoTienda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManagerEcommerce {

    //  La llave es el Canal (Enum) y el valor es la Lista de Observadores
    private Map<TipoEventoTienda, List<EventListenerTienda>> listeners = new HashMap<>();

    public EventManagerEcommerce() {
        // Creamos automáticamente una lista vacía (ArrayList) para cada canal del Enum
        for (TipoEventoTienda canal : TipoEventoTienda.values()) {
            listeners.put(canal, new ArrayList<>());
        }
    }

    public void subscribe(TipoEventoTienda eventType, EventListenerTienda listener) {
        // 1. Buscamos el cajón (la lista) de ese canal
        List<EventListenerTienda> listaDelCanal = listeners.get(eventType);
        // 2. Agregamos al observador a esa lista
        listaDelCanal.add(listener);
    }

    public void unsubscribe(TipoEventoTienda eventType, EventListenerTienda listener) {
        // 1. Buscamos la lista de ese canal y eliminamos al observador
        List<EventListenerTienda> listaDelCanal = listeners.get(eventType);
        listaDelCanal.remove(listener);
    }

    public void notify(TipoEventoTienda eventType, DatosEventoPedido data) {
        // 1. Sacamos únicamente la lista del canal que queremos notificar
        List<EventListenerTienda> listaDelCanal = listeners.get(eventType);

        // 2. Recorremos esa lista con un for normal y avisamos a cada uno
        for (EventListenerTienda listener : listaDelCanal) {
            listener.update(eventType, data);
        }
    }
}