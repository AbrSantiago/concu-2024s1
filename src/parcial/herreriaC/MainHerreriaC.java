import parcial.herreriaC.EspecialistaC;
import parcial.herreriaC.HerreriaC;
import parcial.herreriaC.PeleadorC;

public static void main() {
    HerreriaC herreria = new HerreriaC();
    for (int i = 0; i < 3; i++) {
        EspecialistaC especialista = new EspecialistaC(i, herreria);
        especialista.start();
    }
    for (int i = 0; i < 3; i++) {
        PeleadorC peleador = new PeleadorC(i, 1, herreria);
        peleador.start();
    }
}