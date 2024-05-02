package parcial.museo;

public class EquipoRenovacion extends Thread {
    Museo museo;

    // Escritor
    public EquipoRenovacion(Museo museo) {
        this.museo = museo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            museo.permisoRenovar.acquireUninterruptibly();
            System.out.println("Renovando obras");
            museo.permisoRenovar.release();
        }
    }
}
