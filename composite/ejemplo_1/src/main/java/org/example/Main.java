package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. Crear el nodo raíz (Menú Principal del Restaurante)
        MenuComponent allMenus = new MenuCategory("MENÚ GENERAL DEL RESTAURANTE");

        // 2. Crear las categorías principales (Composites)
        MenuComponent breakfastMenu = new MenuCategory("Menú de Desayunos");
        MenuComponent lunchMenu = new MenuCategory("Menú Almuerzos");
        MenuComponent drinksMenu = new MenuCategory("Menú de Bebidas");

        // Subcategoría dentro de bebidas
        MenuComponent alcoholicDrinks = new MenuCategory("Bebidas con Alcohol");

        // 3. Crear los platos individuales (Nodos hoja - Items)
        // Desayunos
        MenuComponent item1 = new MenuItem("Huevos rancheros", 8.50);
        MenuComponent item2 = new MenuItem("Café americano con pan tostado", 3.00);

        // Almuerzos
        MenuComponent item3 = new MenuItem("Bandeja Paisa", 15.00);
        MenuComponent item4 = new MenuItem("Sopa de Pollo", 7.50);

        // Bebidas sin alcohol
        MenuComponent item5 = new MenuItem("Limonada de Coco", 4.50);
        MenuComponent item6 = new MenuItem("Jugo natural de Mora", 3.50);

        // Bebidas con alcohol (para la subcategoría)
        MenuComponent item7 = new MenuItem("Cerveza Artesanal", 5.00);
        MenuComponent item8 = new MenuItem("Vino tinto (Copa)", 7.00);

        // 4. Construir la jerarquía (Árbol)
        // Llenar Desayunos
        breakfastMenu.add(item1);
        breakfastMenu.add(item2);

        // Llenar Almuerzos
        lunchMenu.add(item3);
        lunchMenu.add(item4);

        // Llenar Bebidas (incluyendo la subcategoría de alcohol)
        drinksMenu.add(item5);
        drinksMenu.add(item6);

        alcoholicDrinks.add(item7);
        alcoholicDrinks.add(item8);

        drinksMenu.add(alcoholicDrinks); // Agregamos la subcategoría a bebidas

        // Agregar las categorías principales al menú general (Raíz)
        allMenus.add(breakfastMenu);
        allMenus.add(lunchMenu);
        allMenus.add(drinksMenu);

        // 5. Imprimir- t-odo el menu de forma recursiva con una sola llamada
        allMenus.print();
    }
}