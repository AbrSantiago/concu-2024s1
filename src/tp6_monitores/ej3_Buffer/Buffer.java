package tp6_monitores.ej3_Buffer;

public class Buffer {
    int size;
    int start = 0;
    int end = 0;
    Object[] data;

    public Buffer(int size) {
        this.size = size;
        this.data = new Object[size+1];
    }

    synchronized void produce(int item) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        data[start] = item;
        System.out.println("Agrego: "+item);
        start = next(start);
        notifyAll();
    }

    synchronized Object consume() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        Object temp = data[end];
        end = next(end);
        notifyAll();
        return temp;
    }

    private boolean isEmpty() {
        return start == end;
    }

    private boolean isFull() {
        return (start + 1)%(size + 1) == end;
    }

    private int next(int i) {
        return (i + 1)%(size + 1);
    }
}