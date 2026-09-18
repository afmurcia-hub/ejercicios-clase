package org.example;

// 2. Clase Principal para probar el funcionamiento en la clase
public class Main {
    public static void main(String[] args) {

        // Creamos nuestro objeto original
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Camilo");
        usuario1.setApellidos("González Torres");
        usuario1.setEdad(26);
        usuario1.setEstadoCivil("Soltero");

        System.out.println("--- USUARIO 1 ORIGINAL ---");
        System.out.println(usuario1);



        //----------------No implementando el patron -------------------------------

//        No funciona por que los dos estan referenciando el mismo espacio en memoria.
//         Usuario usuario2 = usuario1;


//        Podemos cometer errores, es tedioso , muchas lineas de codigo
//        Usuario usuario2 = new Usuario();
//        usuario2.setEdad(usuario1.getEdad());
//        usuario2.setApellidos(usuario1.getApellidos());
//        usuario2.setNombre(usuario1.getNombre());
//        usuario2.setEstadoCivil(usuario1.getEstadoCivil());





        //----------------Implementando el patron ----------------------------------



        // Clonamos el objeto utilizando el Patrón Prototype
        Usuario usuario2 = usuario1.clone();

        System.out.println("\n--- USUARIO 2 (CLON RECIÉN COPIADO) ---");
        System.out.println(usuario2);

        // Modificamos el estado civil solo en el objeto clonado
        usuario2.setEstadoCivil("Casado");
        usuario2.setEdad(21);

        System.out.println("\n--- DESPUÉS DE MODIFICAR EL CLON (USUARIO 2) ---");
        System.out.println("Usuario 1 (Se mantiene seguro): " + usuario1);
        System.out.println("Usuario 2 (Modificado): " + usuario2);
    }
}