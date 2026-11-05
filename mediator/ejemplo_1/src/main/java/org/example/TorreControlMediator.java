package org.example;

public interface TorreControlMediator {
    void solicitarAterrizaje(Avion avion);
    void solicitarDespegue(Avion avion);
    void registrarAvion(Avion avion);
}
