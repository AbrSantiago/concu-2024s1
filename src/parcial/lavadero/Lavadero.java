package parcial.lavadero;

import java.util.concurrent.Semaphore;

public class Lavadero {
    public Semaphore[] maquinas = {
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true)
    };
    public Semaphore[] permisoLavar = {
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true)
    };
    public Semaphore[] permisoAvanzar = {
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true)
    };
}
