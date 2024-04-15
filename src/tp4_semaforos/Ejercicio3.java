import java.util.concurrent.Semaphore;

public static void main() {
    // Utilizar semáforos para garantizar que el único resultado impreso será R I O OK OK OK
    Semaphore permisoI = new Semaphore(0);
    Semaphore permisoO = new Semaphore(0);
    Semaphore permisoOK = new Semaphore(0);
    Thread T1 = new Thread(() -> {
        System.out.print("R");
        permisoI.release();
        try {
            permisoOK.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("OK");
    });
    Thread T2 = new Thread(() -> {
        try {
            permisoI.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("I");
        permisoO.release();
        try {
            permisoOK.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("OK");
    });
    Thread T3 = new Thread(() -> {
        try {
            permisoO.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("O");
        permisoOK.release();
        permisoOK.release();
        System.out.print("OK");
    });

    T1.start();
    T2.start();
    T3.start();
}
