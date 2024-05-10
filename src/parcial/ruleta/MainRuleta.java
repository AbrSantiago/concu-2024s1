import parcial.ruleta.Apostador;
import parcial.ruleta.Crupier;
import parcial.ruleta.Ruleta;

public static void main() {
    int cantApostadores = 3;

    Ruleta ruleta = new Ruleta(cantApostadores);
    Crupier crupier = new Crupier(ruleta);
    for (int i = 0; i < cantApostadores; i++) {
        Apostador apostador = new Apostador(i, 5, ruleta);
        apostador.start();
    }
    crupier.start();

    /*
    * iniciar partida
    * apuestan
    * no va mas
    * girar ruleta
    * verifican si ganaron o perdieron
    * va de nuevo
    * */
}