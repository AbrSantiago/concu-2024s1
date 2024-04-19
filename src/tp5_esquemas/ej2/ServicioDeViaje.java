package tp5_esquemas.ej2;

import java.util.concurrent.Semaphore;

public class ServicioDeViaje {
    public ServicioDeViaje() {}

    // Bote
    static Semaphore permisoViajar = new Semaphore(0);
    static Semaphore permisoVolver = new Semaphore(0);
    // Persona
    static Semaphore permisoSubir = new Semaphore(1);
    static Semaphore permisoBajar = new Semaphore(0);

    // Se asume que el bote arranca en la costa Este y está vacío
    static Thread Bote = new Thread(() -> {
        while (true) {
            permisoViajar.acquireUninterruptibly();
            System.out.println("Viajando"); // Viajar de Este a Oeste
            permisoBajar.release();
            permisoVolver.acquireUninterruptibly();
            System.out.println("Volviendo"); // Volver
            permisoSubir.release();
        }
    });

    public void trasladarGente() {
        Bote.start();
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            Thread Persona = new Thread(() -> {
                permisoSubir.acquireUninterruptibly();
                System.out.println("Persona " + finalI + " subiendo al bote"); // Subir al bote
                permisoViajar.release();
                permisoBajar.acquireUninterruptibly();
                System.out.println("Persona " + finalI + " bajando del bote"); // Bajar del bote
                permisoVolver.release();
            });
            Persona.start();
        }
    }
    // El bote se queda esperando más gente así que nunca termina
}
