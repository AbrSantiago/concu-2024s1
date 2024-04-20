package tp5_esquemas.ej6a;

public class Persona6 extends Thread {
    private final int id;
    private final Toilet toilet;

    public Persona6(int id, Toilet toilet) {
        this.id = id;
        this.toilet = toilet;
    }

    @Override
    public void run() {
        toilet.permisoUsar.acquireUninterruptibly();
        System.out.println("Persona " + id + " usa baño");
        toilet.permisoUsar.release();
    }
}