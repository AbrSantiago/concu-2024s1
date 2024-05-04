package tp5_esquemas.ej7;

import java.util.concurrent.Semaphore;

public class Puente {
    public int[] cantCirculando = {0, 0};
    public Semaphore[] mutexL = {
            new Semaphore(1, true),
            new Semaphore(1, true)
    };
    public Semaphore permisoCircular = new Semaphore(1, true);
}