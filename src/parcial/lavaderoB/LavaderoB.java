package parcial.lavaderoB;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class LavaderoB {
    public Semaphore[] maquinas = {
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true),
            new Semaphore(1, true)
    };
    public Semaphore[] permisoLaburar = {
            new Semaphore(0, true),
            new Semaphore(0, true),
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
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true)
    };
    public Semaphore[] permisoSubir = {
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true)
    };
    public Semaphore[] permisoBajar = {
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true),
            new Semaphore(0, true)
    };
    public ArrayList<MaquinaB> estaciones = new ArrayList<>();
    public ArrayList<VehiculoB> autos = new ArrayList<>();
    public ArrayList<Robot> bufferRobots = new ArrayList<>(); // Buffer
    public Semaphore permisoAgregar = new Semaphore(0, true);
    public Semaphore permisoSacar = new Semaphore(6, true);
    public int first = 0;
    public int last = 0;
}
