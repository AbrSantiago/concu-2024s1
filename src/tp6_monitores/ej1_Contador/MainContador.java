import tp6_monitores.ej1_Contador.Contador;
import tp6_monitores.ej1_Contador.User;

public static void main() {
    Contador contador = new Contador();
    User t1 = new User(contador, 1500);
    User t2 = new User(contador, 2500);
    t1.start();
    t2.start();
}