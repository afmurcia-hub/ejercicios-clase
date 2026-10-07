package org.example.products;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.example.Box;
@Data // Te da los getters, setters, toString, equals y hashCode
@NoArgsConstructor // Fuerza la creación del constructor vacío: public Product() {}
@AllArgsConstructor // Fuerza la creación del constructor con tod_o public Product(String title, double price) {}
public abstract class Product implements Box {

    protected String title;
    protected double price;


}
