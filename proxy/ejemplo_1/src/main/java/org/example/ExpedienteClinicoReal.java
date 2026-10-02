package org.example;

// Contiene la lógica pesada de desencriptación y consulta a la BD hospitalaria

public class ExpedienteClinicoReal implements ExpedienteClinico {
    private String idPaciente;

    public ExpedienteClinicoReal(String idPaciente) {
        this.idPaciente = idPaciente;
        cargarDatosSensiblesDeBaseDeDatos();
    }


    private void cargarDatosSensiblesDeBaseDeDatos() {
        System.out.println("[BD HOSPITAL] Consultando servidor encriptado para el expediente " + idPaciente + "...");
        try {
            Thread.sleep(1200); // Simula el tiempo de desencriptación y consulta pesada
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[BD HOSPITAL] Expediente desencriptado y cargado en memoria.");
    }


    @Override
    public String obtenerDatosPaciente() {
        return "Historial Clínico [" + idPaciente + "]: Diagnóstico = Hipertensión, Tratamiento = Enalapril 10mg, Alergias = Penicilina.";
    }



}
