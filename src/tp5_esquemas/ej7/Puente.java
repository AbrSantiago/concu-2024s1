package tp5_esquemas.ej7;

import java.util.concurrent.Semaphore;

public class Puente {
    public int circulandoHaciaBSAS = 0; // Dir 0
    public int circulandoHaciaLaPlata = 0; // Dir 1

    public Semaphore mutexBSAS = new Semaphore(1, true);
    public Semaphore mutexLaPlata = new Semaphore(1, true);

    public Semaphore permisoHaciaBSAS = new Semaphore(1, true);
    public Semaphore permisoHaciaLaPlata = new Semaphore(1, true);
}