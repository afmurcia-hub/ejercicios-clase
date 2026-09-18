package org.example;


public class Main {
    public static void main(String[] args) {

        // Creamos nuestro prototipo base de tarjeta de crédito

        CreditCard prototypeCard = new CreditCard("John Amaya", "1234-5678-9012-3456", "12/28", 456);

        System.out.println("--- TARJETA PROTOTIPO ORIGINAL ---");
        System.out.println(prototypeCard);


        // Clonamos la tarjeta para un primer cliente usando el metodo clone() nativo
        CreditCard card1 = prototypeCard.clone();
        card1.setTitularName("Sara Rendon");



        // Clonamos la tarjeta para un segundo cliente
        CreditCard card2 = prototypeCard.clone();
        card2.setTitularName("Valentina Rincon");


        System.out.println("\n--- RESULTADOS DESPUÉS DE CLONAR Y PERSONALIZAR ---");
        System.out.println("Prototipo base (Inalterado): " + prototypeCard);
        System.out.println("Tarjeta 1 (Personalizada):  " + card1);
        System.out.println("Tarjeta 2 (Personalizada):  " + card2);
    }
}