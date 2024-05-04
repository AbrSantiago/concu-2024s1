import tp5_esquemas.ej7.Coche;
import tp5_esquemas.ej7.Puente;

import java.util.Random;

public static void main() {
    Puente puente = new Puente();
    for (int i = 0; i < 10000; i++) {
        Coche coche = new Coche(i, puente, getDir());
        coche.start();
    }
}

private static int getDir() {
    Random r = new Random();
    return Math.abs(r.nextInt()) % 2;
}