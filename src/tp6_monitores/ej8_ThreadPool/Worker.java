package tp6_monitores.ej8_ThreadPool;

import tp6_monitores.ej3_Buffer.Buffer;

public class Worker extends Thread {
    Buffer buffer;

    public Worker(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DummyTask task = (DummyTask) buffer.consume();
                task.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
