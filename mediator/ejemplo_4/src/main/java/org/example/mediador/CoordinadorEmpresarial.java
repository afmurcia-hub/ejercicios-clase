package org.example.mediador;

import org.example.modelo.ContextoTransaccion;
import org.example.modulos.ModuloFraude;
import org.example.modulos.ModuloInventario;
import org.example.modulos.ModuloLogistica;
import org.example.modulos.ModuloPagos;

// El Mediador Concreto gestiona la secuencia transaccional
public class CoordinadorEmpresarial implements MediadorProcesos {

    private final ModuloFraude moduloFraude;
    private final ModuloInventario moduloInventario;
    private final ModuloPagos moduloPagos;
    private final ModuloLogistica moduloLogistica;

    public CoordinadorEmpresarial(ModuloFraude moduloFraude,
                                  ModuloInventario moduloInventario,
                                  ModuloPagos moduloPagos,
                                  ModuloLogistica moduloLogistica) {
        this.moduloFraude = moduloFraude;
        this.moduloInventario = moduloInventario;
        this.moduloPagos = moduloPagos;
        this.moduloLogistica = moduloLogistica;

        // Inyectamos el mediador en cada módulo colega
        this.moduloFraude.setMediador(this);
        this.moduloInventario.setMediador(this);
        this.moduloPagos.setMediador(this);
        this.moduloLogistica.setMediador(this);
    }

    @Override
    public void ejecutarFlujoCompra(ContextoTransaccion contexto) {
        System.out.println("\n[Coordinador] Iniciando workflow transaccional para: " + contexto.getIdTransaccion());

        // Paso 1: Validación de Fraude
        moduloFraude.evaluarRiesgo(contexto);
        if (!contexto.isAprobadoPorFraude()) {
            notificarFallaCritica("ModuloFraude", "Transacción rechazada por alto riesgo de fraude.", contexto);
            return;
        }

        // Paso 2: Reserva de Inventario
        moduloInventario.reservar(contexto);
        if (!contexto.isStockReservado()) {
            notificarFallaCritica("ModuloInventario", "No hay stock suficiente.", contexto);
            return;
        }

        // Paso 3: Procesamiento de Pago
        moduloPagos.cobrar(contexto);
        if (!contexto.isPagoProcesado()) {
            // Compensación: si falla el pago, liberamos el stock previamente reservado
            moduloInventario.revertirReserva(contexto);
            notificarFallaCritica("ModuloPagos", "El pago fue rechazado por la pasarela.", contexto);
            return;
        }

        // Paso 4: Generación de Envío Logístico
        moduloLogistica.prepararEnvio(contexto);

        System.out.println("[Coordinador] ¡Workflow completado con éxito para " + contexto.getCliente() + "!\n");
    }

    @Override
    public void notificarFallaCritica(String moduloOrigen, String motivo, ContextoTransaccion contexto) {
        System.err.println("[FALLA CRITICA en " + moduloOrigen + "] " + motivo + " [ID: " + contexto.getIdTransaccion() + "]");
    }
}
