package tp5_esquemas.ej4b;

import java.util.concurrent.Semaphore;

public class BolicheB {
    public int hombres = 0;
    public int mujeres = 0;
    public Semaphore mutexHombres = new Semaphore(1);
    public Semaphore mutexMujeres = new Semaphore(1);

    public Semaphore permisoEntrarHombre = new Semaphore(1);
    public Semaphore permisoEntrarMujer = new Semaphore(1);

    public BolicheB(){}
}