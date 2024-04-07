import java.util.concurrent.Semaphore;

public static void main() {
    System.out.println("Concu 2024s1");
    // Utilizar semáforos para garantizar que las únicas salidas posibles sean ACERO y ACREO.
    Semaphore permisoC = new Semaphore(0);
    Semaphore permisoR = new Semaphore(0);
    Semaphore permisoO = new Semaphore(0);

    Thread T1 = new Thread(() -> {
        try {
            permisoC.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("C");
        permisoR.release();
        System.out.print("E");
        permisoO.release();
    });

    Thread T2 = new Thread(() -> {
        System.out.print("A");
        permisoC.release();
        try {
            permisoR.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("R");
        try {
            permisoO.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("O");
    });

    T1.start();
    T2.start();
}
