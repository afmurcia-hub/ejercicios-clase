package org.example.models;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.interfaces.OpenAIService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class RealOpenAIService implements OpenAIService {

    private final String apiKey;
    private final HttpClient httpClient;
    private final Gson gson;


    public RealOpenAIService(String apiKey) {
        this.apiKey = apiKey;
        // Instancia el cliente HTTP
        this.httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        // Inicializa la librería Gson para manejar los JSON.
        this.gson = new Gson();
    }

    @Override
    public String askQuestion(String prompt) throws Exception {

        System.out.println("--> [REAL SUBJECT] Conectando a OpenAI vía HTTP... (Consumiendo saldo )");

        // 1. CONSTRUCCIÓN DEL JSON: En lugar de concatenar Strings (lo cual es peligroso y propenso a errores), usamos objetos de Gson.
        JsonObject body = new JsonObject();
        body.addProperty("model", "gpt-3.5-turbo");
        body.addProperty("max_tokens", 100);
        body.addProperty("temperature", 0.7);

        // OpenAI exige que el mensaje vaya dentro de un arreglo con un 'role' y el 'content'.
        JsonObject message = new JsonObject();
        message.addProperty("role", "user"); // Indicamos que somos el usuario preguntando
        message.addProperty("content", prompt); // Contenido

        JsonArray messagesArray = new JsonArray();
        messagesArray.add(message); // Metemos el mensaje en el arreglo
        body.add("messages", messagesArray); // Metemos el arreglo en el cuerpo principal

        //Convertimos_todo ese arbol de objetos Java a un String en formato JSON puro.
        String jsonBody = gson.toJson(body);


        // 2. PETICIÓN HTTP: Construimos el "paquete" que viajará por internet.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        // Enviamos la petición y esperamos la respuesta en formato String.
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Validamos si falló (cualquier código distinto a 200 OK).
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la API de OpenAI: " + response.body());
        }

        // 3. EXTRACCIÓN DE LA RESPUESTA: Convertimos el texto gigante de respuesta otra vez a un objeto Json de Gson.
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        // Navegamos por el JSON de OpenAI: entramos al arreglo "choices", sacamos el primer elemento (0), entramos a "message" y extraemos el "content" como String.
        return jsonResponse.getAsJsonArray("choices")
                .get(0).getAsJsonObject()
                .getAsJsonObject("message")
                .get("content").getAsString();
    }
}