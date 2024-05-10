package tp6_monitores.ej2_Semaforo;

public class Semaforo {
    private int permisos;

    public Semaforo(int permisos) {
        this.permisos = permisos;
    }

    synchronized void acquire() throws InterruptedException {
        while (permisos == 0) {
            wait();
        }
        permisos--;
    }

    synchronized void release() {
        permisos++;
        notify(); // Da lo mmismo usar notifyAll?
    }
}