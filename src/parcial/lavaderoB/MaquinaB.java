package parcial.lavaderoB;

public class MaquinaB extends Thread {
    int id;
    LavaderoB lavadero;
    public int auto;

    public MaquinaB(int id, LavaderoB lavadero) {
        this.id = id;
        this.lavadero = lavadero;
    }

    @Override
    public void run() {
        while(true) {
            lavadero.permisoLaburar[id].acquireUninterruptibly();
            System.out.println("Soy la máquina " + id + " y llegó el auto " + auto);
            if (id == 0) {
                // Sube un robot
                lavadero.permisoSacar.acquireUninterruptibly();
                lavadero.permisoSubir[lavadero.last].release();
                // System.out.println("Soy máquina 0 y el robot "+lavadero.last+" puede subir al auto " + auto);
                lavadero.bufferRobots.get(lavadero.last).auto = auto;
                lavadero.last = (lavadero.last+1) % 6;
                lavadero.permisoAgregar.release();
            } else if (id == 6) {
                lavadero.permisoAgregar.acquireUninterruptibly();
                lavadero.permisoBajar[lavadero.first].release();
                System.out.println("Soy máquina 6 y el robot "+lavadero.first+" puede bajar del auto "+auto);
                lavadero.first = (lavadero.first+1) % 6;
                lavadero.permisoSacar.release();
            } else {
                System.out.println("Máqina " + id + " laburando");
                lavadero.permisoAvanzar[id].release();
            }
        }
    }
}
