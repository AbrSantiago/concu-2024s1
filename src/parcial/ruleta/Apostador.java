package parcial.ruleta;

import java.util.Random;

public class Apostador extends Thread {
    int id;
    int capital;
    Ruleta ruleta;

    public Apostador(int id, int capitalInicial, Ruleta ruleta) {
        this.id = id;
        this.capital = capitalInicial;
        this.ruleta = ruleta;
    }

    @Override
    public void run() {
        System.out.println("Llega el apostador "+id);
        while(capital > 0) {
            ruleta.permisoApostar.acquireUninterruptibly();
            // Robo de permiso
            ruleta.mutexApostador.acquireUninterruptibly();
            ruleta.cantApostando++;
            if (ruleta.cantApostando == 1) {
                ruleta.permisoGirarRuleta.acquireUninterruptibly();
            }
            ruleta.mutexApostador.release();

            int capitalApostado = getCapitalApostado();
            capital-=capitalApostado;
            int nroApostado = getNroApostado();
            System.out.println("Apostador "+id+" apuesta "+capitalApostado+" al "+nroApostado);
            // Devolución de permiso
            ruleta.mutexApostador.acquireUninterruptibly();
            ruleta.cantApostando--;
            if (ruleta.cantApostando == 0) {
                ruleta.permisoGirarRuleta.release();
            }
            ruleta.mutexApostador.release();

            ruleta.permisoVerGanador.acquireUninterruptibly();
            if(nroApostado == ruleta.nroGanador) {
                int capitalGanado = capitalApostado*32;
                capital+=capitalGanado;
                System.out.println("Apostador "+id+": Gané $"+capitalGanado);
                ruleta.permisoIniciarPartida.release();
            } else if (capital == 0) {
                ruleta.mutexRetirarse.acquireUninterruptibly();
                System.out.println("Apostador "+id+": No, mi casa!");
                ruleta.cantApostadores--;
                ruleta.permisoIniciarPartida.release();
                ruleta.mutexRetirarse.release();
            } else {
                System.out.println("Apostador "+id+": Perdí, me quedan $"+capital);
                ruleta.permisoIniciarPartida.release();
            }
        }
    }

    private static int getNroApostado() {
        Random random2 = new Random();
        return random2.nextInt(33);
    }

    private int getCapitalApostado() {
        Random random = new Random();
        return random.nextInt(capital) + 1;
    }
}
