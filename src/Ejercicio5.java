import java.util.concurrent.Semaphore;

public static void main() throws InterruptedException {
    System.out.println("Concu 2024s1");
    // Garantice que la ejecución del programa no pierde sumas (valor final de x=6). Considere la
    // posibilidad de que alguno de los threads no se ejecute, en ese caso los threads restantes deben
    // poder finalizar su ejecución sin quedarse bloqueados (x debe ser la suma de sus incrementos).
    final int[] x = {0};

    Semaphore mutex = new Semaphore(1);
    Semaphore permisoPrint = new Semaphore(0);

    Thread T1 = new Thread(() -> {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        x[0] = x[0] + 1;
        mutex.release();
        permisoPrint.release();
    });

    Thread T2 = new Thread(() -> {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        x[0] = x[0] + 2;
        mutex.release();
        permisoPrint.release();
    });

    Thread T3 = new Thread(() -> {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        x[0] = x[0] + 3;
        mutex.release();
        permisoPrint.release();
    });

    T1.start();
    T2.start();
    T3.start();

    for (int i = 0; i < 3; i++) {
        permisoPrint.acquire();
    }
    System.out.print("Valor final de x: " + x[0]);
}