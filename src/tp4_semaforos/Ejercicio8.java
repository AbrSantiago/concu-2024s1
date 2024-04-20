import java.util.concurrent.Semaphore;

public static void main() throws InterruptedException {
    System.out.println("Concu 2024s1");

    Semaphore permisoT1 = new Semaphore(1);
    Semaphore permisoT2 = new Semaphore(0);

    final int[] n = {50};
    final int[] suma = {0};

    Thread T1 = new Thread(() -> {
        while (n[0] > 0) {
            permisoT1.acquireUninterruptibly();
            n[0] = n[0] - 1;
            permisoT2.release();
        }
        permisoT1.acquireUninterruptibly();
        System.out.print("Valor final de N: " + suma[0]);
    });

    Thread T2 = new Thread(() -> {
        while (true) {
            permisoT2.acquireUninterruptibly();
            suma[0] = suma[0] + 2*n[0] + 1;
            System.out.println("N=" + n[0] + " y SUMA=" + suma[0]);
            permisoT1.release();
        }
    });

    T1.start();
    T2.start();
}