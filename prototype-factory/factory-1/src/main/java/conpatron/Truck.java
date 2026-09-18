package conpatron;

import model.GPSModule;
import model.MotorDiesel;
import model.Licencia;
import model.Vehiculo;

public class Truck implements Vehiculo {
    private GPSModule gps;
    private MotorDiesel motor;
    private Licencia licencia;

    // Constructor que recibe todas las dependencias preparadas
    public Truck(GPSModule gps, MotorDiesel motor, Licencia licencia) {
        this.gps = gps;
        this.motor = motor;
        this.licencia = licencia;
    }

    public void asignarRutaInicial() {
        System.out.println("Ruta asignada con GPS v" + gps.getVersion());
    }

    @Override
    public void start() {
        System.out.println("Arrancando camión con motor de " + motor.getPotencia() +
                " HP y licencia tipo " + licencia.getTipo());
    }

    @Override
    public void stop() {
        System.out.println("Deteniendo camión.");
    }
}
