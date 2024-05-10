package parcial.herreriaB;

import java.util.concurrent.Semaphore;

public class HerreriaB {
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