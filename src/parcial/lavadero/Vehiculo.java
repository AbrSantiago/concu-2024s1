package parcial.lavadero;

public class Vehiculo extends Thread {
    int id;
    Lavadero lavadero;

    public Vehiculo(int id, Lavadero lavadero) {
        this.id = id;
        this.lavadero = lavadero;
    }

    @Override
    public void run() {
        System.out.println("Auto " + id + " llega al lavadero");
        lavadero.maquinas[0].acquireUninterruptibly();
        System.out.println("Auto " + id + " llega a estación 0");
        lavadero.permisoLavar[0].release();
        for (int i = 1; i < 5; i++) {
            lavadero.permisoAvanzar[i-1].acquireUninterruptibly();
            lavadero.maquinas[i].acquireUninterruptibly();
            System.out.println("Auto " + id + " avanzando a estación" + i);
            lavadero.maquinas[i-1].release();
            lavadero.permisoLavar[i].release();
        }
        lavadero.permisoAvanzar[4].acquireUninterruptibly();
        lavadero.maquinas[4].release();
        System.out.println("Auto " + id + " se va del lavadero");
    }
}
