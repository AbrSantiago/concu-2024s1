import parcial.lavadero.Lavadero;
import parcial.lavadero.Maquina;
import parcial.lavadero.Vehiculo;

public static void main() { // FUNCIONA BIEN
    Lavadero lavadero = new Lavadero();
    for (int i = 0; i < 5; i++) {
        Maquina maquina = new Maquina(i, lavadero);
        maquina.start();
    }
    for (int i = 0; i < 10; i++) {
        Vehiculo vehiculo = new Vehiculo(i, lavadero);
        vehiculo.start();
    }
}
