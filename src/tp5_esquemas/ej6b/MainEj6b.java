import tp5_esquemas.ej6b.LimpiadorB;
import tp5_esquemas.ej6b.Persona6b;
import tp5_esquemas.ej6b.ToiletB;

public static void main() throws InterruptedException {
    ToiletB toilet = new ToiletB();
    Persona6b p1 = new Persona6b(1, toilet);
    Persona6b p2 = new Persona6b(2, toilet);
    Persona6b p3 = new Persona6b(3, toilet);
    Persona6b p4 = new Persona6b(4, toilet);
    LimpiadorB l = new LimpiadorB(toilet);

    p1.start();
    l.start();
    p2.start();
    p3.start();
    p4.start();
}