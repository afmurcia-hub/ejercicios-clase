package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    Version version = Version.getInstance();

    public static void main(String[] args) {

        Version version = Version.getInstance();

        UsuarioServicio usuarioServicio = new UsuarioServicio(version);
        CarritoDeCompraServicio carritoDeCompraServicio =  new CarritoDeCompraServicio(version);

    }


    public static void metodootro(){
        Version version = Version.getInstance();

    }

}