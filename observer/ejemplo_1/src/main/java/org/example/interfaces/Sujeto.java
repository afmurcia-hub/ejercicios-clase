package org.example.interfaces;

//Define los métodos para gestionar las suscripciones.
public interface Sujeto {
    void suscribir(Observador observador);
    void desuscribir(Observador observador);
    void notificarObservadores();
}
