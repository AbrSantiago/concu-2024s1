package tp7_mensajes.ej4;

import tp7_mensajes.Channel;
import java.util.Random;

public class Cliente4 extends Thread {
    int id;
    Channel chServer;
    Channel myChannel;

    public Cliente4(int id, Channel chServer) {
        this.id = id;
        this.chServer = chServer;
        this.myChannel = new Channel();
    }

    @Override
    public void run() {
        while (true) {
            Req4 req = new Req4("data data from: "+id, myChannel);
            chServer.send(req);
            System.out.println(id+": "+myChannel.receive());
            sleepRandom();
        }
    }

    private static void sleepRandom() {
        try { Thread.sleep(getRandom()); }
        catch (InterruptedException _) { }
    }

    private static int getRandom() {
        Random r = new Random();
        return 100 + 100*r.nextInt(5);
    }
}