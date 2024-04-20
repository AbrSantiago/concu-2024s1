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
        if (this.dir == 0) {
            // Robo
            puente.mutexBSAS.acquireUninterruptibly();
            puente.permisoHaciaBSAS.acquireUninterruptibly();
            puente.circulandoHaciaBSAS++;
            if (puente.circulandoHaciaBSAS == 1) {
                puente.permisoHaciaLaPlata.acquireUninterruptibly();
            }
            // Leer mientras robo
            System.out.println("Coche " + id + " cruzando hacia BSAS");
            puente.permisoHaciaBSAS.release();
            puente.mutexBSAS.release();
            // Devolución
            puente.mutexBSAS.acquireUninterruptibly();
            puente.circulandoHaciaBSAS--;
            if (puente.circulandoHaciaBSAS == 0) {
                puente.permisoHaciaLaPlata.release();
            }
            puente.mutexBSAS.release();
        } else {
            // Robo
            puente.mutexLaPlata.acquireUninterruptibly();
            puente.permisoHaciaLaPlata.acquireUninterruptibly();
            puente.circulandoHaciaLaPlata++;
            if (puente.circulandoHaciaLaPlata == 1) {
                puente.permisoHaciaBSAS.acquireUninterruptibly();
            }
            // Leer
            System.out.println("Coche " + id + " cruzando hacia La Plata");
            puente.permisoHaciaLaPlata.release();
            puente.mutexLaPlata.release();
            // Devolución
            puente.mutexLaPlata.acquireUninterruptibly();
            puente.circulandoHaciaLaPlata--;
            if (puente.circulandoHaciaLaPlata == 0) {
                puente.permisoHaciaBSAS.release();
            }
            puente.mutexLaPlata.release();
        }
    }
}