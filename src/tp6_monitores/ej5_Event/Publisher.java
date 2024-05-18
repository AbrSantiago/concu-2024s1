package tp6_monitores.ej5_Event;

public class Publisher extends Thread {
    Event event;

    public Publisher(Event event) {
        this.event = event;
    }

    @Override
    public void run() {
        while (true) {
            sleep600();
            event.publish();
        }
    }

    private static void sleep600() {
        try {
            sleep(500);
        } catch (InterruptedException _) {}
    }
}