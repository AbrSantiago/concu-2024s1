import tp5_esquemas.ej6a.Limpiador;
import tp5_esquemas.ej6a.Persona6;
import tp5_esquemas.ej6a.Toilet;

public static void main() {
    Toilet toilet = new Toilet();
    Persona6 p1 = new Persona6(1, toilet);
    Persona6 p2 = new Persona6(2, toilet);
    Persona6 p3 = new Persona6(3, toilet);
    Persona6 p4 = new Persona6(4, toilet);
    Limpiador l = new Limpiador(toilet);

    p1.start();
    l.start();
    p2.start();
    p3.start();
    p4.start();
}