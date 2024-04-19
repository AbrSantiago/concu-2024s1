import tp5_esquemas.ej4b.BolicheB;
import tp5_esquemas.ej4b.PersonaB;
import tp5_esquemas.ej4b.SexoB;

public static void main() {
    BolicheB boliche = new BolicheB();
    for (int i = 0; i < 70; i++) {
        PersonaB cliente = new PersonaB(i, SexoB.random(), boliche);
        cliente.start();
    }
}