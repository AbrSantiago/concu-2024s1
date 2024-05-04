package tp5_esquemas.ej7;

public class Coche extends Thread {
    private final int id;
    private final Puente puente;
    private final int dir;

    public Coche(int id, Puente puente, int dir) {
        this.id = id;
        this.puente = puente;
        this.dir = dir;
    }

    @Override
    public void run() {
        puente.mutexL[dir].acquireUninterruptibly();
        puente.cantCirculando[dir]++;
        if (puente.cantCirculando[dir] == 1) {
            puente.permisoCircular.acquireUninterruptibly(); // Robo
        }
        puente.mutexL[dir].release();

        System.out.println("Coche "+id+" circulando hacia "+dir);

        puente.mutexL[dir].acquireUninterruptibly();
        puente.cantCirculando[dir]--;
        if (puente.cantCirculando[dir] == 0) {
            puente.permisoCircular.release(); // Devolución
        }
        puente.mutexL[dir].release();
    }
}