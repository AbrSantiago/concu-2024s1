import tp6_monitores.ej5_Event.Event;
import tp6_monitores.ej5_Event.Publisher;
import tp6_monitores.ej5_Event.Subscriber;

public static void main() {
    Event event = new Event();
    for (int i = 0; i < 6; i++) {
        Subscriber subscriber = new Subscriber(event);
        subscriber.start();
    }
    Publisher publisher = new Publisher(event);
    publisher.start();
}