package tp7_mensajes.ej5;

import tp7_mensajes.Channel;
import java.util.Random;

public class Server5 extends Thread {
    Channel chServer;

    public Server5(Channel ch) {
        this.chServer = ch;
    }

    @Override
    public void run() {
        while (true) {
            Req5 req = (Req5) chServer.receive();
            Thread t = new Thread(() -> {
                Channel toClient = req.chThreadToClient;
                Channel fromClient = req.chClientToThread;
                int n = getRandom();
                while (n != (int) fromClient.receive()) {
                    toClient.send(false); // Perdió
                }
                toClient.send(true); // Ganó
            });
            t.start();
        }
    }

    private static int getRandom() {
        Random r = new Random();
        return r.nextInt(11);
    }
}