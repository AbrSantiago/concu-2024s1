package tp6_monitores.ej5_Event;

public class Subscriber extends Thread {
    int id;
    Event event;

    public Subscriber(int id, Event event) {
        this.id = id;
        this.event = event;
    }

    @Override
    public void run() {
        try {
            event.subscribe(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void festejar() {
        System.out.println(id+": Me suscribí");
    }

    public void verPublicacion() {
        System.out.println(id+": Leyendo publicación");
    }
}