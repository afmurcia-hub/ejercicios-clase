package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1 modulo - parte autenticacion
        System.out.println("modulo se autenticacion");
        Configuracion configu1 = Configuracion.getInstance();
        configu1.mostrarMensaje();


        // 2 modulo - parte reportes
        System.out.println("modulo de reporte");
        Configuracion configu2 = Configuracion.getInstance();
        configu2.mostrarMensaje();

        //comprobar
        System.out.println("son iguales?");
        System.out.println(configu1==configu2);
        System.out.println(configu1);
        System.out.println(configu2);

    }
}