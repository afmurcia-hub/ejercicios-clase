package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // EL PROBLEMA (Sin Builder):
        //  ¿Qué es "Colombia"? ¿El 28 es la edad o el número de calle?
        // Si cambias el orden de los parametros en el constructor, se daña el sistema

        UsuarioSinBuilder usuarioViejo = new UsuarioSinBuilder("Andrés",
                "Murcia",
                "andres@mail.com",
                "3001234567",
                "Calle 10",
                "Armenia",
                "Colombia",
                28,
                true);




        // LA SOLUCIÓN (Con Builder):
        // Cada valor dice exactamente a qué atributo pertenece. Puedes ponerlos en el orden que quieras
        // y saltarte los que no apliquen sin saturar con constructores vacíos.

        Usuario usuarioNuevo = new Usuario.Builder()
                .apellidos("Murcia ")
                .nombre("")
                .pais("Colombia")
                .email("andres@mail.com")
                .ciudad("Armenia")
                .edad(-10)
                .activo(true)
                .build();


        System.out.println(usuarioNuevo);
    }
}