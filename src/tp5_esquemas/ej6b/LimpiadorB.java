package tp5_esquemas.ej6b;

public class LimpiadorB extends Thread{
    private final ToiletB toilet;

    public LimpiadorB(ToiletB toilet) {
        this.toilet = toilet;
    }

    @Override
    public void run() {
        while (true) {
            toilet.persisoEntrar.acquireUninterruptibly();
            toilet.permisoUsar.acquireUninterruptibly(8); // Robo
            toilet.persisoEntrar.release();

            System.out.println("Limpiando baño");
            sleep(500);

            toilet.permisoUsar.release(8); // Devolución
        }
    }

    private static void sleep(int time) {
        try { Thread.sleep(time); }
        catch (InterruptedException e) { throw new RuntimeException(e); }
    }
}
