package org.example.modelo;

public class ReporteDestino {
    private final String pais;
    private final String capital;
    private final double temperatura;
    private final String moneda;

    public ReporteDestino(String pais, String capital, double temperatura, String moneda) {
        this.pais = pais;
        this.capital = capital;
        this.temperatura = temperatura;
        this.moneda = moneda;
    }

    public String getPais() {
        return pais;
    }

    public String getCapital() {
        return capital;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public String getMoneda() {
        return moneda;
    }

    @Override
    public String toString() {
        return String.format("Destino: %s | Capital: %s | Clima: %.1f°C | Moneda: %s",
                pais.toUpperCase(), capital, temperatura, moneda);
    }
}