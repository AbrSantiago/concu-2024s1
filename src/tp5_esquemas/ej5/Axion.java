package tp5_esquemas.ej5;

import java.util.concurrent.Semaphore;

public class Axion {
    public int camiones = 0;
    public int autos = 0;

    public Axion() {}

    public Semaphore abastecedor = new Semaphore(1);
    public Semaphore surtidores = new Semaphore(6);

    public Semaphore mutexCamion = new Semaphore(1);
    public Semaphore mutexAuto = new Semaphore(1);

    public Semaphore permisoCamion = new Semaphore(1);
    public Semaphore permisoAuto = new Semaphore(1);

    public Semaphore mutexP = new Semaphore(1);
}