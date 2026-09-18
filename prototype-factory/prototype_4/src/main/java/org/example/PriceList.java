package org.example;

import java.util.ArrayList;
import java.util.List;

public class PriceList implements IPrototype {

    private String name;
    private List<Product> productList = new ArrayList<>();

    // Constructor que inicializa la lista de precios con su nombre
    public PriceList(String name) {
        this.name = name;
    }

    // CLONACIÓN SIMPLE (Shallow Copy)
    @Override
    public IPrototype clone() {
        PriceList clone = new PriceList(name);
        // ¡Atención aquí! Copia la referencia de la lista directamente.
        // El nuevo objeto PriceList apuntará exactamente a los MISMOS productos en memoria.
        clone.setProductList(productList);
        return clone;
    }



    // CLONACIÓN PROFUNDA (Deep Copy)
    @Override
    public IPrototype deepClone() {
        PriceList clone = new PriceList(name);
        List<Product> cloneProducts = new ArrayList<>();

        // Recorre la lista de productos originales y clona CUNO de ellos individualmente
        for (Product product : productList) {
            // Se hace un casting porque el metodo clone devuelve IPrototype
            Product cloneProduct = (Product) product.clone();
            cloneProducts.add(cloneProduct); // Se agregan a una lista totalmente nueva
        }

        // Asocia la nueva lista de productos independientes a la copia de la lista de precios
        clone.setProductList(cloneProducts);
        return clone;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // Metodo toString personalizado para imprimir la dirección de memoria en hexadecimal
    // y ver si comparten o no los mismos elementos internos.
    @Override
    public String toString() {
        return Integer.toHexString(System.identityHashCode(this)) + " - PriceList{" +
                "name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}