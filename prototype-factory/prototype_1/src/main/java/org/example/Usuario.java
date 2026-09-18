package org.example;

//Clase Usuario que implementa Cloneable (o define su propio mecanismo de clonación)


public class Usuario implements Cloneable {

    private String nombre;
    private String apellidos;
    private int edad;
    private String estadoCivil;

    // Constructor vacío
    public Usuario() {

    }

    // Constructor con parámetros
    public Usuario(String nombre, String apellidos, int edad, String estadoCivil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


//    // Implementación del metodo de clonación (Prototype)
    @Override
    public Usuario clone() {
        Usuario clonUsuario = new Usuario();
        clonUsuario.setNombre(this.getNombre());
        clonUsuario.setApellidos(this.getApellidos());
        clonUsuario.setEdad(this.getEdad());
        clonUsuario.setEstadoCivil(this.getEstadoCivil());
        return clonUsuario;
    }




    //      ¿Por qué no usamos 'implements Cloneable' ni 'super.clone()'?
    //      - Evitamos las molestas excepciones 'CloneNotSupportedException'.
    //      - Nos libramos de la "magia negra" y de los comportamientos ocultos de Java.
    //      - Obtenemos control total y absoluto sobre cómo se copian los atributos,
    //        garantizando un código más limpio, seguro y fácil de mantener.




//    @Override
//    public Usuario clone() {
//        try {
//            return (Usuario) super.clone(); // Copia superficial nativa a nivel de bytes en memoria
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }



    // Metodo toString para imprimir el estado del objeto claramente
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }


}

