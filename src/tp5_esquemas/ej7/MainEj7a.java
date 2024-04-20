import tp5_esquemas.ej7.Coche;
import tp5_esquemas.ej7.Puente;

import java.util.Random;

public static void main() {
    Puente puente = new Puente();
    for (int i = 0; i < 500; i++) {
        Random r = new Random();
        int dir = r.nextInt() % 2;
        Coche coche = new Coche(i, puente, dir);
        coche.start();
    }
}