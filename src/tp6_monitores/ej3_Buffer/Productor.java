package tp6_monitores.ej3_Buffer;

public class Productor extends Thread {
    int item = 0;
    Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                buffer.produce(i);
                item++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
