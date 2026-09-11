package org.example;

public class Usuario {

    // Atributos privados y finales (inmutables: no pueden cambiar una vez creados)
    private final String nombre;
    private final String apellidos;
    private final String email;
    private final String telefono;
    private final String direccion;
    private final String ciudad;
    private final String pais;
    private final int edad;
    private final boolean activo;


    // Constructor privado: solo el Builder puede usarlo para crear el objeto final
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.apellidos = builder.apellidos;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.direccion = builder.direccion;
        this.ciudad = builder.ciudad;
        this.pais = builder.pais;
        this.edad = builder.edad;
        this.activo = builder.activo;

    }



    // Clase interna encargada de armar el objeto paso a paso
    public static class Builder {

        // Aquí los atributos SÍ son mutables (pueden cambiar mientras se configuran)
        private String nombre;
        private String apellidos;
        private String email;
        private String telefono;
        private String direccion;
        private String ciudad;
        private String pais;
        private int edad;
        private boolean activo;



        // Cada metodo guarda el dato y retorna 'this' para poder encadenarlos con puntos (.)
//        public Builder nombre(String nombre) {
//            this.nombre = nombre;
//            return this;
//        }

        public Builder nombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                this.nombre = "No tiene nombre";
            } else {
                this.nombre = nombre;
            }
            return this;
        }

        public Builder apellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }



        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder ciudad(String ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public Builder pais(String pais) {
            this.pais = pais;
            return this;
        }

//        public Builder edad(int edad) {
//            this.edad = edad;
//            return this;
//        }

        public Builder edad(int edad) {
            this.edad = (edad < 0) ? 0 : edad;
            return this;
        }

        public Builder activo(boolean activo) {
            this.activo = activo;
            return this;
        }

        // Paso final: empaqueta los datos recolectados y entrega el Usuario listo
        public Usuario build() {
            return new Usuario(this);
        }
    }





    // Convierte los datos del objeto en texto legible para la consola
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email +
                ", telefono=" + telefono + ", ciudad=" + ciudad + ", pais=" + pais + ", edad=" + edad + "]";
    }
}