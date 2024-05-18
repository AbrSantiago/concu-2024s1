package tp6_monitores.ej8_ThreadPool;

public class DummyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing task...");
    }
}
