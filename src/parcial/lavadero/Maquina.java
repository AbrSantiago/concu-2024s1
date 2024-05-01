package parcial.lavadero;

public class Maquina extends Thread {
    int id;
    Lavadero lavadero;

    public Maquina(int id, Lavadero lavadero) {
        this.id = id;
        this.lavadero = lavadero;
    }

    @Override
    public void run() {
        while(true) {
            lavadero.permisoLavar[id].acquireUninterruptibly();
            System.out.println("Máqina " + id + " laburando");
            lavadero.permisoAvanzar[id].release();
        }
    }
}
