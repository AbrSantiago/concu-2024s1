package parcial.herreriaC;

public class PeleadorC extends Thread {
    int id;
    int estilo;
    HerreriaC herreria;

    public PeleadorC(int id, int estilo, HerreriaC herreria) {
        this.id = id;
        this.estilo = estilo; // 0,1 = Pesado,Ligero
        this.herreria = herreria;
    }

    @Override
    public void run() {
        System.out.println("Peleador "+id+" llega a la herrería");
        if (estilo == 0) {
            herreria.permisoEquiparse[0].acquireUninterruptibly();
            System.out.println("Peleador "+id+" agarra equipo pesado");
            System.out.println("Peleador "+id+" paga con material pesado");
            herreria.permisoForjar[0].release();
        } else {
            herreria.permisoEquiparse[1].acquireUninterruptibly();
            herreria.permisoEquiparse[2].acquireUninterruptibly();
            System.out.println("Peleador "+id+" agarra equipo ligero");
            System.out.println("Peleador "+id+" paga con material ligero");
            herreria.permisoForjar[1].release();
            herreria.permisoForjar[2].release();
        }
        System.out.println("Peleador "+id+" combatiendo para siempre");
    }
}