package tp6_monitores.ej3_Buffer;

public class Buffer {
    int size;
    int start = 0;
    int end = 0;
    Object[] items;

    public Buffer(int size) {
        this.size = size;
        this.items = new Object[size+1];
    }

    public synchronized void produce(Object item) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        items[start] = item;
        System.out.println("Agrego: "+item);
        start = next(start);
        notifyAll();
    }

    public synchronized Object consume() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        Object temp = items[end];
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