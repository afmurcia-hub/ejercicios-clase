package org.example.model;


import java.time.LocalTime;

public record CotizacionReal(
        String simbolo,
        double precioAnterior,
        double precioActual,
        double diferenciaUsd,
        LocalTime horaLectura
) {}
