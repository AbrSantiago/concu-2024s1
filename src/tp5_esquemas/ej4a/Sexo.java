package tp5_esquemas.ej4a;

import java.util.Random;

public enum Sexo {
    HOMBRE,
    MUJER;

    public static Sexo random() {
        Random r = new Random();
        int i = r.nextInt();
        if (i % 2 == 0) {
            return HOMBRE;
        } else {
            return MUJER;
        }
    }
}
