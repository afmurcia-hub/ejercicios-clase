package org.example;

public class Configuracion {
    // 3 partes basicas
    // 1: variable estatica
    private static Configuracion instancia;

    // 2 : clase con constructor privado
    private Configuracion(){
        System.out.println("Inicia configuracion en sistema");
    }

    // 3: un metodo publico que sea estatico
    public static Configuracion getInstance(){
        if(instancia == null){
            instancia = new Configuracion();
        }
        return instancia;
    }

    //opcional metodo
    public void mostrarMensaje(){
        System.out.println("configuracion activa");
    }
}
