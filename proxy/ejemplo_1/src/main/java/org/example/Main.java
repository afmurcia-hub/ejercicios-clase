package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("=== CASO 1: Acceso intentado por RECEPCIONISTA ===");
        ExpedienteClinico expRecepcion = new ProxyExpedienteClinico("PAC-8849", "Laura Pérez", "RECEPCIONISTA");
        System.out.println("Resultado: " + expRecepcion.obtenerDatosPaciente());


        System.out.println("\n=== CASO 2: Acceso intentado por MÉDICO ===");
        ExpedienteClinico expMedico = new ProxyExpedienteClinico("PAC-8849", "Dr. Carlos Gómez", "MEDICO");
        System.out.println("\n--- Primera consulta (descarga desde BD) ---");
        System.out.println("Resultado: " + expMedico.obtenerDatosPaciente());


        System.out.println("\n--- Segunda consulta (mismo médico en la misma sesión) ---");
        System.out.println("Resultado: " + expMedico.obtenerDatosPaciente());

    }
}