package parcial.ruleta;

import java.util.Random;

public class Crupier extends Thread {
    Ruleta ruleta;

    public Crupier(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    @Override
    public void run() {
        while (ruleta.cantApostadores > 0) {
            ruleta.mutexRetirarse.acquireUninterruptibly();
            ruleta.permisoIniciarPartida.acquireUninterruptibly(ruleta.cantApostadores);
            ruleta.mutexRetirarse.release();
            System.out.println("\n----------- Arrnaca la partida -----------");
            ruleta.permisoApostar.release(ruleta.cantApostadores);
            ruleta.permisoGirarRuleta.acquireUninterruptibly();
            System.out.println("Crupier: No va más!");
            ruleta.nroGanador = getGanador();
            System.out.println("Crupier: Salió el "+ruleta.nroGanador);
            ruleta.permisoVerGanador.release(ruleta.cantApostadores);
        }
    }

    private static int getGanador() {
        Random random = new Random();
        return random.nextInt(33);
    }
}