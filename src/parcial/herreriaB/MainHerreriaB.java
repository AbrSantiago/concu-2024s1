import parcial.herreriaB.EspecialistaB;
import parcial.herreriaB.HerreriaB;
import parcial.herreriaB.PeleadorB;

public static void main() {
    HerreriaB herreria = new HerreriaB();
    for (int i = 0; i < 3; i++) {
        EspecialistaB especialista = new EspecialistaB(i, herreria);
        especialista.start();
    }
    for (int i = 0; i < 3; i++) {
        PeleadorB peleador = new PeleadorB(i, 1, herreria);
        peleador.start();
    }
}