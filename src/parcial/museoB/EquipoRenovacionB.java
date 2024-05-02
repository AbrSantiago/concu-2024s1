package parcial.museoB;

public class EquipoRenovacionB extends Thread {
    MuseoB museo;

    // Escritor
    public EquipoRenovacionB(MuseoB museo) {
        this.museo = museo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            museo.permisoVisitar.acquireUninterruptibly();
            museo.permisoRenovar.acquireUninterruptibly();
            museo.permisoPausar.acquireUninterruptibly();
            System.out.println("Renovando obras");
            museo.permisoPausar.release();
            museo.permisoRenovar.release();
            museo.permisoVisitar.release();
        }
    }
}