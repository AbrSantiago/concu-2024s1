package tp6_monitores.ej5_Event;

import java.util.ArrayList;

public class Event {
    ArrayList<Subscriber> subs = new ArrayList<>();

    public Event() {}

    public synchronized void publish() {
        System.out.println("Hay nueva publicación");
        notifyAll();
    }

    synchronized void subscribe(Subscriber sub) throws InterruptedException {
        subs.add(sub);
        sub.festejar();
        wait();
        sub.verPublicacion();
    }
}