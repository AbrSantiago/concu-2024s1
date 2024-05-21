package tp7_mensajes;

import java.util.*;

public class Channel {
    Queue<Object> msjs = new LinkedList<>();

    public Channel(){}

    public synchronized void send(Object msj) {
        msjs.add(msj);
        notify();
    }

    public synchronized Object receive() {
        while (msjs.peek() == null) {
            waitPlz();
        }
        return msjs.poll();
    }

    private void waitPlz() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}