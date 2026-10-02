package org.example;

import org.example.config.EnvConfig;
import org.example.interfaces.OpenAIService;
import org.example.proxies.CacheOpenAIProxy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. Llamamos a nuestra clase de configuración para extraer la llave de forma segura.
        String apiKey = EnvConfig.getApiKey();

        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("Por favor, configura tu API Key en el archivo .env");
            return;
        }

        // 2. Instanciamos el Proxy (El cliente interactúa con la abstracción) asume que habla con el servicio, ignora por completo que hay un intermediario.
        OpenAIService aiService = new CacheOpenAIProxy(apiKey);

        try {
            System.out.println("====== PRUEBA 1: LLAMADA NUEVA ======");
            String res1 = aiService.askQuestion("Traduce al inglés: Yo amo comer");
            System.out.println("Respuesta IA: " + res1);

            Thread.sleep(2000);

            System.out.println("\n====== PRUEBA 2: LLAMADA REPETIDA ======");
            String res2 = aiService.askQuestion("Traduce al inglés: Yo amo dormir");
            System.out.println("Respuesta IA: " + res2);

        }
        catch (Exception e) {
            System.err.println("Ocurrió un error en la ejecución: " + e.getMessage());
        }
    }
}