package tp5_esquemas.ej5;

public class Camion extends Thread {
    Axion axion;

    public Camion(Axion axion) {
        this.axion = axion;
    }

    @Override
    public void run() {
        System.out.println("Llega camión");
        // Robo
        axion.mutexCamion.acquireUninterruptibly();
        axion.camiones++;
        if (axion.camiones == 1) {
            axion.permisoAuto.acquireUninterruptibly();
        }
        axion.mutexCamion.release();
        // Escritura
        axion.abastecedor.acquireUninterruptibly();
        System.out.println("Descargando combustible");
        axion.abastecedor.release();
        // Devolución
        axion.mutexCamion.acquireUninterruptibly();
        axion.camiones--;
        if (axion.camiones == 0) {
            axion.permisoAuto.release();
        }
        axion.mutexCamion.release();
        System.out.println("Se va camión");
    }
}