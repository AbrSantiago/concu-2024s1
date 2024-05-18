package tp6_monitores.ej3_Buffer;

public class Consumidor extends Thread {
    Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Object data = buffer.consume();
                System.out.println("Consumiendo "+data);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}