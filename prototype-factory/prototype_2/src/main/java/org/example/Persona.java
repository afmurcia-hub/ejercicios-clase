package org.example;

import java.util.Objects;

//  Clase Persona que implementa la lógica del Patrón Prototype
class Persona {
    private String nombre;
    private int edad;

    // Constructor para inicializar la instancia con sus valores
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo Prototype para clonar el objeto y evitar escribir 'new' pasando atributo por atributo
    public Persona clone() {

        return new Persona(this.nombre, this.edad);
    }

    // Sobrescritura de métodos para impresión y comparación
    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + '}';
    }

    //si tienen los mismos datos, aunque vivan en espacios de memoria diferentes
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }


}


