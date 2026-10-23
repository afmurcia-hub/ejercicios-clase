package org.example;

import org.example.interfaces.ObservadorCripto;
import org.example.publisher.MonitorBinanceReal;
import org.example.subscribers.AlertaVolatilidad;
import org.example.subscribers.RegistradorArchivoCSV;
import org.example.subscribers.TableroConsolaEnVivo;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 1. Creamos el Sujeto (Publisher) apuntando a Bitcoin en Binance
        MonitorBinanceReal monitorBtc = new MonitorBinanceReal("BTCUSDT");

        // 2. Creamos los 3 Observadores (Subscribers) como objetos normales
        ObservadorCripto tablero = new TableroConsolaEnVivo();
        ObservadorCripto archivoCsv = new RegistradorArchivoCSV("historial_btc.csv");
        ObservadorCripto alertaBrusca = new AlertaVolatilidad(10.0); // Alerta si salta >= $10 USD

        // 3. Los suscribimos a la lista del monitor
        monitorBtc.suscribir(tablero);
        monitorBtc.suscribir(archivoCsv);
        monitorBtc.suscribir(alertaBrusca);

        System.out.println("Iniciando monitoreo en vivo con Binance (10 lecturas, una cada 3 segundos)...");

        // 4. Hacemos 10 consultas reales a internet con una pausa de 3 segundos entre cada una
        for (int i = 1; i <= 10; i++) {
            monitorBtc.consultarApiEnVivo();
            Thread.sleep(3000); // Pausa de 3000 milisegundos (3 segundos)
        }

        System.out.println("\n Monitoreo finalizado. Revisa el archivo 'historial_btc.csv' en tu proyecto.");
    }
}