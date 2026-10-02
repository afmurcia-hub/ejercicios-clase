package org.example.adapter.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.adapter.InputFile;
import org.example.model.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class JsonFileAdapter implements InputFile {

    // Implementación del metodo readFile para transformar el flujo de bytes del JSON a List<Person>
    @Override
    public List<Person> readFile(InputStream inputStream) {
        try {
            // 1. Instancia el ObjectMapper de la librería Jackson (motor para leer/escribir JSON)
            ObjectMapper mapper = new ObjectMapper();

            // 2. Lee el InputStream y genera un árbol de nodos (JsonNode) representando la estructura del JSON
            JsonNode rootNode = mapper.readTree(inputStream);

            // 3. Recorre cada elemento dentro del arreglo principal de nodos del JSON
            for (JsonNode node : rootNode) {
                // Verifica que el nodo sea un objeto editable ({ "clave": "valor" })
                if (node instanceof ObjectNode) {
                    ObjectNode objectNode = (ObjectNode) node;

                    // Extrae los valores de las llaves en español ("Nombre", "Apellido", "Edad")
                    // .remove() elimina la propiedad antigua y devuelve el valor que tenía
                    String nombre = objectNode.remove("Nombre").asText();
                    String apellido = objectNode.remove("Apellido").asText();
                    int edad = objectNode.remove("Edad").asInt();

                    // Inserta las nuevas propiedades con los nombres exactos de los atributos de la clase Person
                    objectNode.put("name", nombre);
                    objectNode.put("lastName", apellido);
                    objectNode.put("age", edad);
                }
            }

            // 4. Convierte el árbol de nodos ya transformado en una lista Java de objetos Person

            List<Person> personList = mapper.convertValue(rootNode, new TypeReference<List<Person>>() {});

            // 5. Retorna la lista resultante de personas
            return personList;

        } catch (IOException e) {
            // Manejo de errores de lectura o formato JSON inválido
            throw new RuntimeException(e);
        }
    }
}
