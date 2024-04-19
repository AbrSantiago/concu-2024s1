package tp5_esquemas.ej4b;

import java.util.Random;

public enum SexoB {
    HOMBRE,
    MUJER;

    public static SexoB random() {
        Random r = new Random();
        int i = r.nextInt();
        if (i % 2 == 0) {
            return HOMBRE;
        } else {
            return MUJER;
        }
    }
}