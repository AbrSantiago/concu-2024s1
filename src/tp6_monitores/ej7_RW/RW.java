package tp6_monitores.ej7_RW;

public class RW {
    private String serializable;
    private int readers = 0;
    private int writers = 0;

    public void serialize(String s) {
        System.out.println("Cifrando...");
        delay100();
        this.serializable = s;
    }

    public String deserialize() {
        System.out.println("Descifrando...");
        delay100();
        return serializable;
    }

    public synchronized void beginRead() throws InterruptedException {
        while (!canRead()) {
            wait();
        }
        readers++;
    }

    public synchronized void endRead() {
        readers--;
        if (readers == 0) {
            notify();
        }
    }

    public synchronized void beginWrite() throws InterruptedException {
        while (!canWrite()) {
            wait();
        }
        writers = 1;
    }

    public synchronized void endWrite() {
        writers = 0;
        notifyAll();
    }

    private boolean canWrite() {
        return readers == 0 && writers == 0;
    }

    private boolean canRead() {
        return writers == 0;
    }

    private void delay100() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
