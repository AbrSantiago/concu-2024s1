package parcial.museoB;

import java.util.concurrent.Semaphore;

public class MuseoB {
    int visitantes = 0;
    public Semaphore permisoRenovar = new Semaphore(1, true); // permisoE
    public Semaphore permisoVisitar = new Semaphore(1, true); // permisoL
    public Semaphore mutexL = new Semaphore(1, true);
    public Semaphore mutexP = new Semaphore(1, true);

    // Animatronics
    public Semaphore permisoBailar = new Semaphore(0, false);
    public Semaphore permisoPausar = new Semaphore(1, true);
}