package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// proposito almacebnar varias cajas mas
public class CompositeBox implements Box {
    // Aquí guarda cualquier cosa que sea un "Box" (pueden ser VideoGames u otras CompositeBox)
    private final List<Box> children = new ArrayList<>();

    // El "Varargs" (Box... boxes) permite recibir múltiples elementos separados por coma
    public CompositeBox(Box... boxes) {
        children.addAll(Arrays.asList(boxes));
    }


    @Override
    public double calculatePrice() {
        //Recorre cada elemento de mi lista, ejecuta su metodo calculatePrice() y suma todos los resultados
        return children.stream().mapToDouble(Box::calculatePrice).sum();
    }




}