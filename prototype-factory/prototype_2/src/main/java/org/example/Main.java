package org.example;


// 2. Clase Principal para probar el comportamiento
public class Main {
    public static void main(String[] args) {

        // Creamos nuestro objeto original (Estado Seguro)

        Persona personaOriginal = new Persona("Carlos Alberto Gomez", 30);
        System.out.println("Persona Original: " + personaOriginal);


        // Simulamos la creación de una copia utilizando el Patrón Prototype para editar de forma segura
        Persona personaClon = personaOriginal.clone();


        // Comprobación de espacios en memoria vs valores
        System.out.println("¿Es exactamente el mismo objeto en memoria? (==): " + (personaOriginal == personaClon));
        System.out.println("¿Tienen los mismos valores? (equals): " + personaOriginal.equals(personaClon));


        // Editamos los datos en el objeto clon (simulando la interfaz de usuario)
        personaClon.setEdad(26);

        System.out.println("\n--- DESPUÉS DE EDITAR EL CLON ---");
        System.out.println("Persona Original (Inalterada): " + personaOriginal);
        System.out.println("Persona Clon (Modificada): " + personaClon);
    }
}