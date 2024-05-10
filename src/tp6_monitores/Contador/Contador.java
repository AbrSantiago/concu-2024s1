package tp6_monitores.Contador;

public class Contador {
    private int i;

    synchronized void add() {
        i++;
    }

    synchronized void substract() {
        i--;
    }

    synchronized int get() {
        return i;
    }
}