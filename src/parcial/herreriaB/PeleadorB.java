package parcial.herreriaB;

import java.util.ArrayList;
import java.util.Random;

public class PeleadorB extends Thread {
    int id;
    int estilo;
    HerreriaB herreria;

    public PeleadorB(int id, int estilo, HerreriaB herreria) {
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
        System.out.println("Peleador "+id+" se dirige a la arena");
        while (combatir(estilo).isEmpty()); // Falta
    }

    private ArrayList<Integer> combatir(int estilo) {
        ArrayList<Integer> equipoRoto = new ArrayList<>();
        Random r = new Random();
        int probabilidad = r.nextInt(30);
        switch (estilo) {
            case 0:
                if (probabilidad == 1) {
                    equipoRoto.add(0); break;
                }
            case 1:
                switch (probabilidad) {
                    case 5:  equipoRoto.add(1); break;
                    case 7:  equipoRoto.add(2); break;
                    case 17: equipoRoto.add(1); equipoRoto.add(2); break;
                }
        }
        return equipoRoto;
    }
}