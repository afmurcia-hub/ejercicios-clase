package org.example;

// Intermediario que aplica auditoría, validación de seguridad y carga diferida
public class ProxyExpedienteClinico implements ExpedienteClinico {
    private String idPaciente;
    private String nombreUsuario;
    private String rolUsuario;
    private ExpedienteClinicoReal expedienteReal; // Referencia interna al sujeto real

    public ProxyExpedienteClinico(String idPaciente, String nombreUsuario, String rolUsuario) {
        this.idPaciente = idPaciente;
        this.nombreUsuario = nombreUsuario;
        this.rolUsuario = rolUsuario;
    }

    @Override
    public String obtenerDatosPaciente() {

        // 1. Auditoría obligatoria (Smart Reference / Logging)
        System.out.println("[REGISTRO AUDITORÍA] Intento de acceso de '" + nombreUsuario + "' (" + rolUsuario + ") al expediente " + idPaciente);


        // 2. Control de acceso por rol (Protection Proxy)
        if (!"MEDICO".equalsIgnoreCase(rolUsuario) && !"ADMIN_CLINICA".equalsIgnoreCase(rolUsuario)) {
            return "[ACCESO DENEGADO] El rol '" + rolUsuario + "' no tiene autorización para ver expedientes clínicos.";
        }


        // 3. Carga Diferida / Lazy Loading (Virtual Proxy)
        if (expedienteReal == null) {
            System.out.println("[PROXY] Permiso verificado. Conectando a la BD por primera vez...");
            expedienteReal = new ExpedienteClinicoReal(idPaciente);
        }


        // 4. Delegación al objeto real
        return expedienteReal.obtenerDatosPaciente();





    }
}