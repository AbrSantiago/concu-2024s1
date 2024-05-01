package parcial.lavaderoB;

public class VehiculoB extends Thread {
    int id;
    LavaderoB lavadero;

    public VehiculoB(int id, LavaderoB lavadero) {
        this.id = id;
        this.lavadero = lavadero;
    }

    @Override
    public void run() {
        System.out.println("Auto " + id + " llega al lavadero");
        lavadero.maquinas[0].acquireUninterruptibly();
        lavadero.estaciones.getFirst().auto = id;
        System.out.println("Auto " + id + " llega a estación 0");
        lavadero.permisoLaburar[0].release();
        for (int i = 1; i < 7; i++) {
            lavadero.permisoAvanzar[i-1].acquireUninterruptibly();
            lavadero.maquinas[i].acquireUninterruptibly();
            System.out.println("Auto " + id + " avanzando a estación " + i);
            lavadero.estaciones.get(i).auto = id;
            lavadero.maquinas[i-1].release();
            lavadero.permisoLaburar[i].release();
        }
        lavadero.permisoAvanzar[6].acquireUninterruptibly();
        lavadero.maquinas[6].release();
        System.out.println("Auto " + id + " se va del lavadero");
    }
}
