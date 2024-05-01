package parcial.lavaderoB;

public class Robot extends Thread {
    int id;
    LavaderoB lavadero;
    public int auto;

    public Robot(int id, LavaderoB lavadero) {
        this.id = id;
        this.lavadero = lavadero;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Robot "+id+" ready");
            lavadero.permisoSubir[id].acquireUninterruptibly();
            System.out.println("Robot " + id + " sube al auto " + auto + " y limpia");
            lavadero.permisoAvanzar[0].release();
            lavadero.permisoBajar[id].acquireUninterruptibly();
            System.out.println("Robot " + id + " baja del auto " + auto);
            lavadero.permisoAvanzar[6].release();
        }
    }
}
