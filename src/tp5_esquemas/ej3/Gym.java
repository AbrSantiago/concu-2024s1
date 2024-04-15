package tp5_esquemas.ej3;

import java.util.concurrent.Semaphore;

public class Gym {
    public Gym() {}

    Semaphore[] aparatos = {
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1),
            new Semaphore(1)
    };
    Semaphore discos = new Semaphore(20);
    Semaphore mutexTomarDiscos = new Semaphore(1);
}