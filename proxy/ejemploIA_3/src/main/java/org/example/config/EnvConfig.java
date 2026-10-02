package org.example.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Lector del .env
public class EnvConfig {
    public static String getApiKey() {

        Dotenv dotenv = Dotenv.load();

        return dotenv.get("OPENAI_API_KEY");
    }
}
