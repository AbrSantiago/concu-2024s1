package tp6_monitores.ej5_Event;

public class Event {
    private int epoch;

    public Event() {}

    public synchronized void publish() {
        System.out.println("-------- Hay nueva publicación --------");
        epoch++;
        notifyAll();
    }

    synchronized void subscribe() throws InterruptedException {
        System.out.println("Hay nuevo sub");
        int current = epoch;
        while (current == epoch) {
            wait();
        }
    }
}