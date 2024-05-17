import tp6_monitores.ej5_Event.Event;
import tp6_monitores.ej5_Event.Subscriber;

public static void main() { // Falta corregir algunos detalles
    Event event = new Event();
    for (int i = 0; i < 10; i++) {
        Subscriber subscriber = new Subscriber(i, event);
        subscriber.start();
    }
    event.publish();
}