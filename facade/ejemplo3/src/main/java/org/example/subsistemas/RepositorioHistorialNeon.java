package org.example.subsistemas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Repositorio encargado de gestionar la conexión y las operaciones con la base de datos
 * PostgreSQL alojada en Neon para almacenar el historial de consultas de turismo.
 */
public class RepositorioHistorialNeon {

    private final String urlConexion;

    /**
     * Constructor de la clase. Carga la configuración del archivo .env o variables de entorno,
     * valida la existencia de la URL de conexión y verifica/crea la tabla en la base de datos.
     */
    public RepositorioHistorialNeon() {
        // Carga el archivo .env de la raíz del proyecto automáticamente
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Intenta leer la URL del .env, y si no está presente, busca directamente en el sistema operativo
        String urlEnv = dotenv.get("NEON_DB_URL", System.getenv("NEON_DB_URL"));

        // Valida que la URL no sea nula ni esté vacía para evitar fallos posteriores
        if (urlEnv == null || urlEnv.isBlank()) {
            throw new IllegalStateException("La variable de entorno 'NEON_DB_URL' no está configurada o el archivo .env no fue cargado.");
        }

        this.urlConexion = urlEnv;

        // Asegura que la estructura de la tabla esté lista al instanciar el repositorio
        crearTablaSiNoExiste();
    }


    /**
     * Abre y retorna una nueva conexión activa con la base de datos de Neon.
     *
     * @return Objeto Connection activo.
     * @throws SQLException Si ocurre un error al intentar conectar.
     */
    private Connection abrirConexion() throws SQLException {
        return DriverManager.getConnection(urlConexion);
    }

    /**
     * Crea la tabla 'consultas_turismo' en la base de datos si es que esta no existe todavía,
     * estableciendo la estructura de columnas necesaria para los registros.
     */
    private void crearTablaSiNoExiste() {
        String sql = """
            CREATE TABLE IF NOT EXISTS consultas_turismo (
                id SERIAL PRIMARY KEY,
                cedula_cliente VARCHAR(20) NOT NULL,
                nombre_cliente VARCHAR(150) NOT NULL,
                pais VARCHAR(100) NOT NULL,
                capital VARCHAR(100),
                temperatura NUMERIC(4, 1),
                moneda VARCHAR(80),
                fecha_consulta TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            );
        """;

        // Try-with-resources garantiza el cierre automático de la conexión y el statement
        try (Connection conn = abrirConexion();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("[Neon DB] Tabla 'consultas_turismo' verificada en Neon.");
        } catch (SQLException e) {
            System.err.println("[Neon DB] Error al verificar tabla: " + e.getMessage());
        }
    }






    /**
     * Registra una nueva consulta turística realizada por un cliente en la base de datos.
     * @ cedulaCliente Cédula o documento de identidad del cliente.
     * @param nombreCliente Nombre completo del cliente.
     * @param pais          País consultado.
     * @param capital       Capital del país.
     * @param temperatura   Temperatura registrada en la capital.
     * @param moneda        Moneda oficial del país.
     */
    public void registrarConsulta(String cedulaCliente, String nombreCliente, String pais, String capital, double temperatura, String moneda) {
        String sql = """
            INSERT INTO consultas_turismo (cedula_cliente, nombre_cliente, pais, capital, temperatura, moneda)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        // Utiliza PreparedStatement para mapear los parámetros de forma segura y evitar inyecciones SQL
        try (Connection conn = abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cedulaCliente);
            pstmt.setString(2, nombreCliente);
            pstmt.setString(3, pais);
            pstmt.setString(4, capital);
            pstmt.setDouble(5, temperatura);
            pstmt.setString(6, moneda);

            pstmt.executeUpdate();
            System.out.println("[Neon DB] Consulta registrada a nombre de " + nombreCliente + " (CC: " + cedulaCliente + ").");
        } catch (SQLException e) {
            System.err.println("[Neon DB] Error insertando registro: " + e.getMessage());
        }
    }
}