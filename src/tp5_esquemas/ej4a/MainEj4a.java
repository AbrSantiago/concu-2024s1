import tp5_esquemas.ej4a.Boliche;
import tp5_esquemas.ej4a.Persona;
import tp5_esquemas.ej4a.Sexo;

public static void main() {
    Boliche boliche = new Boliche();
    for (int i = 0; i < 10; i++) {
        Persona cliente = new Persona(i, Sexo.random(), boliche);
        cliente.start();
    }
}