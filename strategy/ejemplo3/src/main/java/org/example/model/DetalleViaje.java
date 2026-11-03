package org.example.model;

public class DetalleViaje {
    private double distanciaKm;
    private double duracionMinutos;
    private int horaDelDia; // 0 a 23
    private boolean altaDemanda;

    public DetalleViaje(double distanciaKm, double duracionMinutos, int horaDelDia, boolean altaDemanda) {
        this.distanciaKm = distanciaKm;
        this.duracionMinutos = duracionMinutos;
        this.horaDelDia = horaDelDia;
        this.altaDemanda = altaDemanda;
    }

    public double getDistanciaKm() { return distanciaKm; }
    public double getDuracionMinutos() { return duracionMinutos; }
    public int getHoraDelDia() { return horaDelDia; }
    public boolean isAltaDemanda() { return altaDemanda; }
}
