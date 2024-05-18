package tp6_monitores.ej5_Event;

public class Subscriber extends Thread {
    Event event;

    public Subscriber(Event event) {
        this.event = event;
    }

    @Override
    public void run() {
        while (true) {
            sleep500();
            subscribe();
        }
    }

    private void subscribe() {
        try { event.subscribe(); } catch (InterruptedException _) {}
    }

    private static void sleep500() {
        try {
            sleep(500);
        } catch (InterruptedException _) {}
    }
}