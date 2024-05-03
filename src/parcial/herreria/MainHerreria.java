import parcial.herreria.Especialista;
import parcial.herreria.Herreria;
import parcial.herreria.Peleador;

public static void main() {
    Herreria herreria = new Herreria();
    for (int i = 0; i < 3; i++) {
        Especialista especialista = new Especialista(i, herreria);
        especialista.start();
    }
    for (int i = 0; i < 3; i++) {
        Peleador peleador = new Peleador(i, 1, herreria);
        peleador.start();
    }
}