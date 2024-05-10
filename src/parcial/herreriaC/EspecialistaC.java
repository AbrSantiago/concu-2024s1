package parcial.herreriaC;

public class EspecialistaC extends Thread {
    int id;
    HerreriaC herreria;

    public EspecialistaC(int id, HerreriaC herreria) {
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