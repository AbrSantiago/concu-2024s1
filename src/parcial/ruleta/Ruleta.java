package parcial.ruleta;

import java.util.concurrent.Semaphore;

public class Ruleta {
    public int cantApostadores;
    public int cantApostando = 0;
    public int nroGanador;
    public Semaphore mutexRetirarse = new Semaphore(1, true);
    public Semaphore mutexApostador = new Semaphore(1, true);
    public Semaphore permisoApostar = new Semaphore(0, true);
    public Semaphore permisoGirarRuleta = new Semaphore(1);
    public Semaphore permisoVerGanador = new Semaphore(0, true);
    public Semaphore permisoIniciarPartida;

    public Ruleta(int cantApostadores) {
        this.cantApostadores = cantApostadores;
        this.permisoIniciarPartida = new Semaphore(cantApostadores, true);
    }
}
