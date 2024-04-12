import java.util.concurrent.Semaphore;

@SuppressWarnings("BusyWait")
public static void main() throws InterruptedException {
    System.out.println("Concu 2024s1");

    Semaphore permisoA = new Semaphore(1);
    Semaphore permisoB = new Semaphore(0);

    Thread T1 = new Thread(() -> {
        while (true) {
            try {
                permisoA.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("A");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            permisoB.release();
        }
    });

    Thread T2 = new Thread(() -> {
        while (true) {
            try {
                permisoB.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("B");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            permisoA.release();
        }
    });

    T1.start();
    T2.start();
}