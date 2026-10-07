package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ProductLeaf implements CatalogComponent {
    private int productId;
    private String title;
    private double price;

    public ProductLeaf(int productId) {
        this.productId = productId;
        fetchProductData();
    }

    private void fetchProductData() {
        try {
            // Construye la URL del endpoint concatenando el ID específico del producto
            String url = "https://dummyjson.com/products/" + productId;

            // Instancia el cliente HTTP para manejar la conexión
            HttpClient client = HttpClient.newHttpClient();

            // Configura la petición HTTP definiendo la URI de destino y el metodo (GET)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Envía la solicitud de forma síncrona y captura el cuerpo de la respuesta como texto (String)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Evalúa si el servidor respondió con éxito
            if (response.statusCode() == 200) {
                // Convierte el texto plano de la respuesta en un objeto JSON estructurado
                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

                // Extrae los valores clave del JSON y actualiza el estado interno del objeto
                this.title = json.get("title").getAsString();
                this.price = json.get("price").getAsDouble();
            } else {
                // Asigna valores por defecto si el servidor responde con un error
                this.title = "Producto no encontrado";
                this.price = 0.0;
            }
        } catch (Exception e) {
            // Captura cualquier excepción técnica
            this.title = "Error de conexión";
            this.price = 0.0;
        }
    }

    @Override
    public void showDetails() {
        System.out.println("    📦 [ID: " + productId + "] " + title + " — $" + price);
    }

    @Override
    public double getTotalPrice() {
        return price;
    }
}