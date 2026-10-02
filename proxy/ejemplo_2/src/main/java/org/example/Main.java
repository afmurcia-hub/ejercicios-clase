package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("=== CASO 1: CLIENTE ACTIVO EN LA TIENDA ===");
        ServicioProducto tienda = new ProxyServicioProducto("ACTIVO");

        System.out.println("\n--- Primera consulta (Conexión a BD y almacenamiento en Caché) ---");
        System.out.println("Resultado: " + tienda.obtenerDetalleProducto("PROD-9901"));


        System.out.println("\n--- Segunda consulta (Mismo producto: Recuperado de Caché al instante) ---");
        System.out.println("Resultado: " + tienda.obtenerDetalleProducto("PROD-9901"));

        System.out.println("\n=== CASO 2: USUARIO CON CUENTA SUSPENDIDA ===");
        ServicioProducto tiendaBloqueada = new ProxyServicioProducto("SUSPENDIDO");
        System.out.println(tiendaBloqueada.obtenerDetalleProducto("PROD-9901"));
    }
}