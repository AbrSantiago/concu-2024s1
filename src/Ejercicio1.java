import java.util.concurrent.Semaphore;

public static void main() {
    System.out.println("Concu 2024s1");
    // Utilizar semáforos para garantizar que, simultáneamente, "A" se
    // muestra antes que "F", y "F" se muestra antes que "C".
    Semaphore permisoF = new Semaphore(0);
    Semaphore permisoC = new Semaphore(0);

    Thread T1 = new Thread(() -> {
        System.out.print("A");
        permisoF.release();
        System.out.print("B");
        try {
            permisoC.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("C");
    });

    Thread T2 = new Thread(() -> {
        System.out.print("E");
        try {
            permisoF.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("F");
        permisoC.release();
        System.out.print("G");
    });

    T1.start();
    T2.start();
}