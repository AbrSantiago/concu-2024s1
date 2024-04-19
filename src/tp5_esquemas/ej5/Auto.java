package tp5_esquemas.ej5;

public class Auto extends Thread {
    Axion axion;

    public Auto(Axion axion) {
        this.axion = axion;
    }

    @Override
    public void run() {
        System.out.println("Llega auto");
        // Robo
        axion.mutexP.acquireUninterruptibly();
        axion.mutexAuto.acquireUninterruptibly();
        axion.permisoAuto.acquireUninterruptibly();
        axion.autos++;
        if (axion.autos == 1) {
            axion.permisoCamion.acquireUninterruptibly();
        }
        axion.permisoAuto.release();
        axion.mutexAuto.release();
        axion.mutexP.release();
        // Lectura
        axion.surtidores.acquireUninterruptibly(); // Preguntar si puede ir antes
        System.out.println("Caragando combustible");
        axion.surtidores.release();
        // Devolución
        axion.mutexAuto.acquireUninterruptibly();
        axion.autos--;
        if (axion.autos == 0) {
            axion.permisoCamion.release();
        }
        axion.mutexAuto.release();
        System.out.println("Se va auto");
    }
}