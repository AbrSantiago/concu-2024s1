package tp5_esquemas;

import java.util.concurrent.Semaphore;

public class ServicioDeViaje2 {
    public ServicioDeViaje2() {}

    // Bote
    static Semaphore permisoViajarAlOeste = new Semaphore(2);
    static Semaphore permisoViajarAlEste = new Semaphore(0);
    // Persona
    static Semaphore permisoSubirEnElEste = new Semaphore(2);
    static Semaphore permisoSubirEnElOeste = new Semaphore(0);
    static Semaphore permisoBajarEnElEste = new Semaphore(0);
    static Semaphore permisoBajarEnElOeste = new Semaphore(0);

    // Se asume que el bote arranca en la costa Este y está vacío
    static Thread Bote = new Thread(() -> {
        while (true) {
            permisoViajarAlOeste.acquireUninterruptibly(4);
            System.out.println("Viajando al Oeste"); // Viajar al Oeste
            permisoBajarEnElOeste.release(2);
            permisoSubirEnElOeste.release(2);
            permisoViajarAlEste.acquireUninterruptibly(4);
            System.out.println("Viajando al Este"); // Viajar al Este
            permisoBajarEnElEste.release(2);
            permisoSubirEnElEste.release(2);
        }
    });

    public void trasladarGente() {
        Bote.start();
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            Thread PersonaOriental = new Thread(() -> {
                permisoSubirEnElEste.acquireUninterruptibly();
                System.out.println("Persona Oriental " + finalI + " sube"); // Subir al bote
                permisoViajarAlOeste.release();
                permisoBajarEnElOeste.acquireUninterruptibly();
                System.out.println("Persona Oriental " + finalI + " baja"); // Bajar del bote
                permisoViajarAlEste.release();
            });
            PersonaOriental.start();
        }
        for (int i = 10; i < 14; i++) {
            int finalI = i;
            Thread PersonaOccidental = new Thread(() -> {
                permisoSubirEnElOeste.acquireUninterruptibly();
                System.out.println("Persona Occidental " + finalI + " sube"); // Subir al bote
                permisoViajarAlEste.release();
                permisoBajarEnElEste.acquireUninterruptibly();
                System.out.println("Persona Occidental " + finalI + " baja"); // Bajar del bote
                permisoViajarAlOeste.release();
            });
            PersonaOccidental.start();
        }
    }
    // El bote se queda esperando más gente así que nunca termina
}
