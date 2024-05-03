package parcial.herreria;

public class Especialista extends Thread {
    int id;
    Herreria herreria;

    public Especialista(int id, Herreria herreria) {
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