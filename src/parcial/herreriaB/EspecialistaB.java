package parcial.herreriaB;

public class EspecialistaB extends Thread {
    int id;
    HerreriaB herreria;

    public EspecialistaB(int id, HerreriaB herreria) {
        this.id = id;
        this.herreria = herreria;
    }

    @Override
    public void run() {
        // 0,1,2 = Pesado,Ligero,Escudo
        while (true) {
            herreria.permisoForjar[id].acquireUninterruptibly();
            System.out.println("Herrero " + id + " forja equipo");
            herreria.permisoEquiparse[id].release();
        }
    }
}