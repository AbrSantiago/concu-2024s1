package tp5_esquemas.ej6b;

public class LimpiadorB extends Thread{
    private final ToiletB toilet;

    public LimpiadorB(ToiletB toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            // Robo
            toilet.persisoEntrar.acquireUninterruptibly();
            toilet.permisoUsar.acquireUninterruptibly(8);
            toilet.persisoEntrar.release();
            //
            System.out.println("Limpiando baño");
            try { Thread.sleep(500); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
            // Devolución
            toilet.permisoUsar.release(8);
        }
    }
}
