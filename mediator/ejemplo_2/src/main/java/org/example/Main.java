package org.example;

import org.example.colegas.Estudiante;
import org.example.colegas.Profesor;
import org.example.mediador.MediadorChat;
import org.example.mediador.SalaClaseVirtual;

public class Main {
    public static void main(String[] args) {
        // 1. Crear el Mediador Concreto
        MediadorChat salaClase = new SalaClaseVirtual();

        // 2. Crear los Colegas (Estudiantes y Profesor) pasándoles el mediador
        Profesor profeCarlos = new Profesor(salaClase, "Carlos");
        Estudiante ana = new Estudiante(salaClase, "Ana");
        Estudiante andres = new Estudiante(salaClase, "Andrés");

        // 3. Registrar los colegas en el mediador
        salaClase.registrarUsuario(profeCarlos);
        salaClase.registrarUsuario(ana);
        salaClase.registrarUsuario(andres);

        System.out.println("\n================ SIMULACIÓN DE CLASE ================");

        // Escenario 1: Conversación normal
        ana.hablarATodos("¡Hola profe, buenos días!");

        // Escenario 2: Mensaje privado entre estudiantes usando el mediador
        andres.hablarPrivado("Ana, ¿entendiste el ejercicio de mediador?", "Ana");

        // Escenario 3: El profesor activa el modo silencio (Regla de negocio intermedia)
        profeCarlos.cambiarModoSilencio();

        // Escenario 4: Un estudiante intenta hablar con la clase silenciada
        andres.hablarATodos("Profe, una duda...");

        // Escenario 5: El profesor habla aunque la clase esté silenciada
        profeCarlos.hablarATodos("Por favor guarden silencio para explicar el patrón.");
    }
}