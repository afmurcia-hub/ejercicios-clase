package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // ==========================================
        // 1. FORMA TRADICIONAL (Sin Builder)
        // Tres casas con constructores gigantes y difíciles de leer
        // ==========================================

        // Casa 1: Campestre de Madera
        CasaSinBuilder casaCampestreVieja = new CasaSinBuilder(
                "Madera", 1, 120.0, "Natural",
                false, 6, false, true,
                false, 3, "Teja", "Rural",
                new String[]{"Porche", "Chimenea"}
        );

        // Casa 2: Ciudad Normal
        CasaSinBuilder casaCiudadVieja = new CasaSinBuilder(
                "Ladrillo", 2, 90.0, "Rojo",
                false, 8, true, false,
                false, 4, "Concreto", "Urbano",
                new String[]{"Garaje Integrado", "Balcón pequeño"}
        );

        // Casa 3: Chalet con Piscina
        CasaSinBuilder casaChaletVieja = new CasaSinBuilder(
                "Concreto y Vidrio", 3, 250.0, "Blanco",
                true, 15, true, true,
                true, 5, "Teja Plana", "Suburbano",
                new String[]{"Piscina Infinita", "Terraza", "Jardín Grande"}
        );


        // ==========================================
        // 2. CON PATRÓN BUILDER (Clase Casa optimizada)
        // Tres casas creadas de forma limpia, ordenada y autodescriptiva
        // ==========================================

        // Casa 1: Campestre de Madera
        Casa casaCampestreNueva = new Casa.Builder()
                .tipoEstructura("Madera")
                .numeroPisos(1)
                .area(120.0)
                .colorPintura("Natural")
                .tienePiscina(false)
                .numeroVentanas(6)
                .tieneGaraje(false)
                .tieneJardin(true)
                .tieneBalcon(false)
                .numeroHabitaciones(3)
                .materialTecho("Teja")
                .entorno("Rural")
                .caracteristicas(new String[]{"Porche", "Chimenea"})
                .build();




        // Casa 2: Ciudad Normal
        Casa casaCiudadNueva = new Casa.Builder()
                .tipoEstructura("Ladrillo")
                .numeroPisos(2)
                .area(90.0)
                .colorPintura("Rojo")
                .tienePiscina(false)
                .numeroVentanas(8)
                .tieneGaraje(true)
                .tieneJardin(false)
                .tieneBalcon(false)
                .numeroHabitaciones(4)
                .materialTecho("Concreto")
                .entorno("Urbano")
                .caracteristicas(new String[]{"Garaje Integrado", "Balcón pequeño"})
                .build();

        // Casa 3: Chalet con Piscina
        Casa casaChaletNueva = new Casa.Builder()
                .tipoEstructura("Concreto y Vidrio")
                .numeroPisos(3)
                .area(250.0)
                .colorPintura("Blanco")
                .tienePiscina(true)
                .numeroVentanas(15)
                .tieneGaraje(true)
                .tieneJardin(true)
                .tieneBalcon(true)
                .numeroHabitaciones(5)
                .materialTecho("Teja Plana")
                .entorno("Suburbano")
                .caracteristicas(new String[]{"Piscina Infinita", "Terraza", "Jardín Grande"})
                .build();

        // Mostramos detalles para comprobar que funcionan
        System.out.println("--- CASAS CON BUILDER ---");
        casaCampestreNueva.mostrarDetalles();
        casaCiudadNueva.mostrarDetalles();
        casaChaletNueva.mostrarDetalles();
        System.out.println(casaCampestreNueva.toString());

    }
}