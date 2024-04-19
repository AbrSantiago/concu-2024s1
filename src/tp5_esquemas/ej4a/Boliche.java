package tp5_esquemas.ej4a;

import java.util.concurrent.Semaphore;

public class Boliche {
    public Semaphore permisoEntrarHombre = new Semaphore(1);
    public Semaphore permisoEntrarMujer = new Semaphore(1);

    public Boliche(){}
}