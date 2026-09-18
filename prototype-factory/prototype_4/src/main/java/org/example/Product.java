package org.example;

// La clase implementa IPrototype (preparada para el patrón Prototype)
public class Product implements IPrototype {

    // Atributos básicos del producto
    private String name;
    private double price;

    // Constructor para inicializar el producto con su nombre y precio
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }




    // Metodo de clonación simple: crea un nuevo objeto en memoria con los mismos valores
    @Override
    public IPrototype clone() {
        Product product = new Product(this.name, this.price);
        return product;
    }



    // Metodo de clonación profunda: como el producto no tiene objetos internos complejos,
    // simplemente reutiliza el metodo de clonación simple.
    @Override
    public IPrototype deepClone() {
        return clone();
    }






    // Obtiene el nombre del producto
    public String getName() {
        return name;
    }

    // Modifica el nombre del producto
    public void setName(String name) {
        this.name = name;
    }

    // Obtiene el precio del producto
    public double getPrice() {
        return price;
    }

    // Modifica el precio del producto
    public void setPrice(double price) {
        this.price = price;
    }

    // Metodo toString personalizado: imprime la dirección de memoria en hexadecimal
    // junto con los datos del producto para poder rastrear copias fácilmente.
    @Override
    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + " - Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}