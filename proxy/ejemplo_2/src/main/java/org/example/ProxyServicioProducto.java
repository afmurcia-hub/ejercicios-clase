package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProxyServicioProducto implements ServicioProducto {
    private ServicioProductoReal servicioReal;
    private Map<String, String> cacheProductos;
    private String estadoUsuario;

    public ProxyServicioProducto(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
        this.cacheProductos = new HashMap<>();
    }

    @Override
    public String obtenerDetalleProducto(String idProducto) {
        // 1. Control de Acceso (Protection Proxy)
        if ("SUSPENDIDO".equalsIgnoreCase(estadoUsuario)) {
            return "[PROXIED ERROR] Acceso denegado: La cuenta del usuario se encuentra suspendida.";
        }

        // 2. Consulta en Memoria Caché (Caching Proxy)
        if (cacheProductos.containsKey(idProducto)) {
            System.out.println("[PROXY CACHÉ] Producto " + idProducto + " encontrado en memoria. Respuesta inmediata sin tocar la BD.");
            return cacheProductos.get(idProducto);
        }

        // 3. Carga Diferida (Virtual Proxy)
        if (servicioReal == null) {
            System.out.println("[PROXY] Primera petición autorizada. Inicializando conexión al servicio real...");
            servicioReal = new ServicioProductoReal();
        }

        // 4. Delegación al objeto real y almacenamiento en caché
        System.out.println("[PROXY] Reenviando solicitud a la BD...");
        String resultado = servicioReal.obtenerDetalleProducto(idProducto);
        cacheProductos.put(idProducto, resultado);

        return resultado;
    }
}
