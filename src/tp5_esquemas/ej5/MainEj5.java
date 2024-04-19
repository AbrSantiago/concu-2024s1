import tp5_esquemas.ej5.Auto;
import tp5_esquemas.ej5.Axion;
import tp5_esquemas.ej5.Camion;

public static void main() {
    Axion axion = new Axion();
    for (int i=0; i<10; i++) {
        Auto auto = new Auto(axion);
        auto.start();
    }
    for (int i=0; i<3; i++) {
        Camion camion = new Camion(axion);
        camion.start();
    }
}