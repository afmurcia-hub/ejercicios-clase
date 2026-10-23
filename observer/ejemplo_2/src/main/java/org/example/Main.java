package org.example;
import org.example.listeners.BodegaReabastecimientoListener;
import org.example.listeners.FacturacionElectronicaListener;
import org.example.model.TipoEventoTienda;
import org.example.publisher.ProcesadorPedidos;
import org.example.listeners.NotificadorWhatsAppListener;
import org.example.listeners.SeguridadAntifraudeListener;


public class Main {
    public static void main(String[] args) {

        // 1. Creamos el publicador principal (la tienda)
        ProcesadorPedidos tienda = new ProcesadorPedidos();


        // 2. Creamos los 4 observadores como objetos
        FacturacionElectronicaListener facturacion = new FacturacionElectronicaListener();
        BodegaReabastecimientoListener bodega = new BodegaReabastecimientoListener();
        NotificadorWhatsAppListener whatsapp = new NotificadorWhatsAppListener();
        SeguridadAntifraudeListener antifraude = new SeguridadAntifraudeListener();


        // 3. Suscripción selectiva por canal
        tienda.events.subscribe(TipoEventoTienda.PAGO_APROBADO, facturacion);
        tienda.events.subscribe(TipoEventoTienda.PAGO_APROBADO, whatsapp);
        tienda.events.subscribe(TipoEventoTienda.STOCK_CRITICO, bodega);
        tienda.events.subscribe(TipoEventoTienda.ALERTA_FRAUDE, antifraude);


        // ================= SIMULACIÓN DE COMPRAS =================

        // Compra 1: 2 portatiles (Stock baja de 5 a 3).
        // Solo reaccionan Facturación y WhatsApp. Bodega sigue en silencio porque quedan 3.
        tienda.procesarCheckout("ORD-101", "carlos@mail.com", "portatil-dell", 2, 4_500_000);

        // Compra 2: 2 portatiles más (Stock baja de 3 a 1).
        // Reaccionan Facturación, WhatsApp Y AHORA SÍ salta la alerta de Bodega (queda 1 unidad <= 2).
        tienda.procesarCheckout("ORD-102", "ana@empresa.co", "portatil-dell", 2, 4_500_000);

        // Compra 3: Alguien intenta comprar 5 portatiles de golpe ($22,500,000 > límite de $15M).
        // No se factura ni se descuenta stock; salta únicamente el canal ALERTA_FRAUDE.
        tienda.procesarCheckout("ORD-103", "hacker@dark.net", "portatil-dell", 5, 4_500_000);
    }
}