package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== CONECTANDO A LA FAKE STORE API Y ARMANDO EL CATÁLOGO ===");

        // 1. Creamos productos individuales pasándoles su ID de la API (Hojas)
        // ID 1: Fendi Backpack, ID 2: Mens Casual Premium Slim Fit T-Shirts, ID 9: WD 2TB Elements
        CatalogComponent product1 = new ProductLeaf(1);
        CatalogComponent product2 = new ProductLeaf(2);
        CatalogComponent product3 = new ProductLeaf(10);

        // 2. Creamos subcategorías (Composites)
        CategoryComposite mensClothing = new CategoryComposite("Ropa de Caballero");
        mensClothing.addComponent(product1);
        mensClothing.addComponent(product2);

        CategoryComposite electronics = new CategoryComposite("Electrónica y Almacenamiento");
        electronics.addComponent(product3);

        // 3. Creamos la categoría raíz de la tienda que agrupa_todo
        CategoryComposite rootStore = new CategoryComposite("TIENDA VIRTUAL GLOBAL ");
        rootStore.addComponent(mensClothing); // Subcategoría dentro de la tienda
        rootStore.addComponent(electronics);   // Subcategoría dentro de la tienda

        // 4. Mostramos el árbol completo con una sola llamada
        rootStore.showDetails();

        // 5. Calculamos el valor total de inventario de toda la tienda de forma recursiva
        System.out.println("\n--------------------------------------------------");
        System.out.println("💰 VALOR TOTAL DEL INVENTARIO EN LA API: $" + rootStore.getTotalPrice());
        System.out.println("--------------------------------------------------");
    }
}