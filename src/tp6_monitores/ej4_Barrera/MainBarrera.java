import tp6_monitores.ej4_Barrera.Barrera;
import tp6_monitores.ej4_Barrera.BarreraUser;

public static void main() {
    int threads = 4;
    Barrera barrera = new Barrera(threads);
    for (int i = 0; i < threads; i++) {
        BarreraUser user = new BarreraUser(barrera);
        user.start();
    }
}