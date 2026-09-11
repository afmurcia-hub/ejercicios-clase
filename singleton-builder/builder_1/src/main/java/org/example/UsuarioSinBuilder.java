package org.example;

public class UsuarioSinBuilder {
    private final String nombre;
    private final String apellidos;
    private final String email;
    private final String telefono;
    private final String direccion;
    private final String ciudad;
    private final String pais;
    private final int edad;
    private final boolean activo;

    // Constructor gigante de 9 parámetros (¡Un peligro si te equivocas de orden!)
    public UsuarioSinBuilder(String nombre, String apellidos, String email, String telefono,
                             String direccion, String ciudad, String pais, int edad, boolean activo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.edad = edad;
        this.activo = activo;
    }
}
