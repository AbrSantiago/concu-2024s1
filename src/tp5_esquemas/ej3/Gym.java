package tp5_esquemas.ej3;

import java.util.concurrent.Semaphore;

public class Gym {
    public Gym() {}

    Semaphore[] aparatos = {
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true)
    };
    Semaphore discos = new Semaphore(20, true);
    Semaphore mutexTomarDiscos = new Semaphore(1, true);
}