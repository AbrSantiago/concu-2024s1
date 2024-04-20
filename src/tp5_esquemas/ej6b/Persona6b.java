package tp5_esquemas.ej6b;

public class Persona6b extends Thread {
    private final int id;
    private final ToiletB toilet;

    public Persona6b(int id, ToiletB toilet) {
        this.id = id;
        this.toilet = toilet;
    }

    @Override
    public void run() {
        // Robo
        toilet.mutexP.acquireUninterruptibly();
        toilet.persisoEntrar.acquireUninterruptibly();
        toilet.permisoUsar.acquireUninterruptibly();
        toilet.persisoEntrar.release();
        toilet.mutexP.release();
        //
        System.out.println("Persona " + id + " usa baño");
        // Devolución
        toilet.permisoUsar.release();
    }
}