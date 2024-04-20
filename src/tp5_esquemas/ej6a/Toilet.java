package tp5_esquemas.ej6a;

import java.util.concurrent.Semaphore;

public class Toilet {
    public Semaphore permisoUsar = new Semaphore(8);
}