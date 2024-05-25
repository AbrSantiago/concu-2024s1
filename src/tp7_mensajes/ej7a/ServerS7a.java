package tp7_mensajes.ej7a;

import tp7_mensajes.Channel;

public class ServerS7a extends Thread {
    Channel ch1, ch2;

    public ServerS7a(Channel ch1, Channel ch2) {
        this.ch1 = ch1;
        this.ch2 = ch2;
    }

    @Override
    public void run() {
        while (true) {
            int i = (int) ch1.receive();
            sleep500();
            ch2.send(10*i);
        }
    }

    private static void sleep500() {
        try { Thread.sleep(500); }
        catch (InterruptedException _) { }
    }
}