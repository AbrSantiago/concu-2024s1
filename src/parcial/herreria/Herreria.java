package parcial.herreria;

import java.util.concurrent.Semaphore;

public class Herreria {
    Semaphore[] permisoForjar = {
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1)
    };
    Semaphore[] permisoEquiparse = {
            new Semaphore(0),
            new Semaphore(0),
            new Semaphore(0)
    };
}