package tp5_esquemas.ej6a;

public class Limpiador extends Thread {
    private final Toilet toilet;

    public Limpiador(Toilet toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            toilet.permisoUsar.acquireUninterruptibly(8);
            System.out.println("Limpiando baño");
            try { Thread.sleep(500); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
            toilet.permisoUsar.release(8);
        }
    }
}