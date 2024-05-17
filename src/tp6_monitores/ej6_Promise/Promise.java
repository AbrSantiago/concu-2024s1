package tp6_monitores.ej6_Promise;

public class Promise implements Future {
    Object x;

    @Override
    public synchronized Object get() throws InterruptedException {
        while (x == null) {
            wait();
        }
        Object temp = x;
        x = null;
        return temp;
    }

    public synchronized void set(Object x) {
        this.x = x;
        notifyAll();
    }
}