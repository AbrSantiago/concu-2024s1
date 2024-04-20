package tp5_esquemas.ej6b;

import java.util.concurrent.Semaphore;

public class ToiletB {
    public Semaphore permisoUsar = new Semaphore(8);
    public Semaphore persisoEntrar = new Semaphore(1);
    public Semaphore mutexP = new Semaphore(1);
}