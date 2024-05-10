package tp6_monitores.ej1_Contador;

public class Contador {
    private int i = 0;

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