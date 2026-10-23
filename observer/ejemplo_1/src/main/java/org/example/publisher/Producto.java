package org.example.publisher;


import org.example.interfaces.Observador;
import org.example.interfaces.Sujeto;

import java.util.ArrayList;
import java.util.List;

//Es el objeto cuyo estado importa. Contiene la lista de observadores y dispara la notificación cuando su precio cambia.
public class Producto implements Sujeto {
    private final String nombre;
    private double precio;
    private final List<Observador> observadores;

    public Producto(String nombre, double precioInicial) {
        this.nombre = nombre;
        this.precio = precioInicial;
        this.observadores = new ArrayList<>();
    }

    public void setPrecio(double nuevoPrecio) {
        System.out.println("\n[TIENDA] El precio de '" + this.nombre + "' cambió de $" + this.precio + " a $" + nuevoPrecio);
        this.precio = nuevoPrecio;
        notificarObservadores();
    }

    @Override
    public void suscribir(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar(this.nombre, this.precio);
        }
    }
}
