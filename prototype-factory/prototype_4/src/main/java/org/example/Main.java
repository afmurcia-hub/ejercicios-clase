package org.example;

import org.example.PriceList;
import org.example.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. CREACIÓN DE LA LISTA ORIGINAL
        // Se crea un objeto PriceList llamado "Lista normal"
        PriceList priceList = new PriceList("Lista normal");

        // Se define una lista inmutable de productos usando List.of()
        List<Product> productList = List.of(
                new Product("Computadora", 650000),
                new Product("Mouse", 120000),
                new Product("Teclado", 80000),
                new Product("Pantalla", 1350000),
                new Product("Auriculares", 40000)
        );

        // Se asocian los productos a la lista original
        priceList.setProductList(productList);

        // Imprime la lista original (muestra su dirección de memoria hexadecimal y sus productos)
        System.out.println(priceList);


        // 2. SEGUNDA LISTA - CLONACIÓN SUPERFICIAL (clone)
        // Se clona la lista de forma simple. Se hace casting (PriceList) porque clone() devuelve IPrototype.
        PriceList priceList2 = (PriceList) priceList.clone();
        priceList2.setName("Lista Prefer");

        // Al ser clonación superficial, la lista de productos es la MISMA en memoria.
        // Modificar el precio aquí afectará también a la lista original.
        for (Product product : priceList2.getProductList()){
            product.setPrice(product.getPrice() * 0.9); // Aplica 10% de descuento
        }

        // Imprime la segunda lista (verás que comparte las referencias de los productos con la original)
        System.out.println(priceList2);


        // 3. TERCERA LISTA - CLONACIÓN PROFUNDA (deepClone)
        // Se clona profundamente. Se crea un objeto PriceList nuevo y TAMBIÉN se clonan uno por uno sus productos.
        PriceList priceList3 = (PriceList) priceList.deepClone();
        priceList3.setName("Lista VIP");

        // Al ser clonación profunda, los productos son totalmente independientes en memoria.
        // Modificar el precio aquí NO afecta a las listas anteriores.
        for (Product product : priceList3.getProductList()){
            product.setPrice(product.getPrice() * 0.5); // Aplica 50% de descuento
        }

        // Imprime la tercera lista (verás direcciones de memoria completamente nuevas para sus productos)
        System.out.println(priceList3);
    }
}