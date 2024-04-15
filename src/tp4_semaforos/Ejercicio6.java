import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public static void main() throws InterruptedException {
    System.out.println("Concu 2024s1");
    // Los posibles valores de x son 0, 1 y 3.
    AtomicInteger y = new AtomicInteger();
    AtomicInteger z = new AtomicInteger();

    Semaphore permisoT2 = new Semaphore(0);
    Semaphore permisoPrint = new Semaphore(0);

    AtomicInteger x = new AtomicInteger(); // En realidad va dentro del thread
    Thread T1 = new Thread(() -> {
        x.set(y.get() + z.get());
        permisoT2.release();
        permisoPrint.release();
    });

    Thread T2 = new Thread(() -> {
        try {
            permisoT2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        y.set(1);
        z.set(2);
        permisoPrint.release();
    });

    T1.start();
    T2.start();

    for (int i = 0; i < 2; i++) {
        permisoPrint.acquire();
    }
    System.out.print("Valor final de x: " + x.get());

    // Analogamente para x=1 y x=3
}