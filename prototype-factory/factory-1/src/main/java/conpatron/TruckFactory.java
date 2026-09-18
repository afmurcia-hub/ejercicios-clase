package conpatron;

import model.GPSModule;
import model.Licencia;
import model.MotorDiesel;
import model.Vehiculo;

public class TruckFactory {

    public Vehiculo createTruck(int potenciaMotor) {
        // La factoría construye y configura las dependencias internas
        GPSModule gps = new GPSModule("v2.1");
        MotorDiesel motor = new MotorDiesel(potenciaMotor); // Recibe 400 o 500
        Licencia licencia = new Licencia("Especial C3");

        Truck camion = new Truck(gps, motor, licencia);

        camion.asignarRutaInicial();

        return camion;
    }
}
