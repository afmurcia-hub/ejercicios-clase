package org.example.proxies;

import org.example.interfaces.OpenAIService;
import org.example.models.RealOpenAIService;

import java.util.HashMap;
import java.util.Map;

public class CacheOpenAIProxy implements OpenAIService {

    // El Proxy tiene por dentro al sujeto real. Él controla cuándo usarlo.
    private final OpenAIService realService;

    // El HashMap será nuestra base de datos temporal en memoria ( Clave -> Valor).
    private final Map<String, String> cache;

    public CacheOpenAIProxy(String apiKey) {
        this.realService = new RealOpenAIService(apiKey);
        this.cache = new HashMap<>();
    }

    @Override
    public String askQuestion(String prompt) throws Exception {
        System.out.println("\n[PROXY] Interceptando petición: \"" + prompt + "\"");

        if (cache.containsKey(prompt)) {
            System.out.println("[PROXY] Devolviendo respuesta en memoria (Ahorro de saldo)");
            return cache.get(prompt);
        }

        System.out.println("[PROXY]  No encontrado en caché. Delegando al servicio real...");
        String response = realService.askQuestion(prompt);

        cache.put(prompt, response);
        System.out.println("[PROXY]  Respuesta guardada en caché.");

        return response;
    }
}
