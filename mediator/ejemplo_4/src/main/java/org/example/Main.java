package org.example;

import org.example.mediador.CoordinadorEmpresarial;
import org.example.modelo.ContextoTransaccion;
import org.example.modulos.ModuloFraude;
import org.example.modulos.ModuloInventario;
import org.example.modulos.ModuloLogistica;
import org.example.modulos.ModuloPagos;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar los módulos de negocio
        ModuloFraude fraude = new ModuloFraude();
        ModuloInventario inventario = new ModuloInventario();
        ModuloPagos pagos = new ModuloPagos();
        ModuloLogistica logistica = new ModuloLogistica();

        // 2. Instanciar el Mediador
        CoordinadorEmpresarial coordinador = new CoordinadorEmpresarial(fraude, inventario, pagos, logistica);

        // 3. Crear el contexto de una transacción real
        ContextoTransaccion tx1 = new ContextoTransaccion("TX-88392", "Andrés Felipe Murcia", 3500.00);

        // 4. Ejecutar el flujo completo a través del mediador
        coordinador.ejecutarFlujoCompra(tx1);
    }
}