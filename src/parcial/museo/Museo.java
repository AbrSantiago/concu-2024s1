package parcial.museo;

import java.util.concurrent.Semaphore;

public class Museo {
    int visitantes = 0;
    public Semaphore permisoRenovar = new Semaphore(1, true); // permisoE
    public Semaphore mutexL = new Semaphore(1, true);
    public Semaphore permisoBailar = new Semaphore(0, false);
}