package tp5_esquemas.ej3;

import java.util.List;

public class Cliente extends Thread{
    private final int id;
    private final List<Ejercicio> rutina;
    private final Gym gym;

    public Cliente(int id, List<Ejercicio> rutina, Gym gym) {
        this.id = id;
        this.rutina = rutina;
        this.gym = gym;
    }

    @Override
    public void run() {
        System.out.println("Llega cliente " + id);
        for (Ejercicio ejercicio : rutina) {
            gym.mutexTomarDiscos.acquireUninterruptibly();
            for (int i = ejercicio.discos; i>0; i--) {
                gym.discos.acquireUninterruptibly();
            }
            gym.mutexTomarDiscos.release();
            gym.aparatos[ejercicio.aparato].acquireUninterruptibly();
            System.out.println("Cliente " + id + " hace ejercicio...");
            try { sleep(500); }
            catch (InterruptedException e) { throw new RuntimeException(e); }
            gym.aparatos[ejercicio.aparato].release();
            for (int i = ejercicio.discos; i>0; i--) {
                gym.discos.release();
            }
        }
        System.out.println("Adiós cliente " + id);
    }
}