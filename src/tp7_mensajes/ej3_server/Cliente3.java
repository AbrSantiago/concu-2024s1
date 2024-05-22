package tp7_mensajes.ej3_server;

import tp7_mensajes.Channel;

import java.util.Random;

public class Cliente3 extends Thread {
    int id;
    Channel chServer;
    Channel myChannel;

    public Cliente3(int id, Channel chServer) {
        this.id = id;
        this.chServer = chServer;
        this.myChannel = new Channel();
    }

    @Override
    public void run() {
        while (true) {
            Req3 req;
            if (getRandom() % 3 == 0) {
                req = new Req3("Read", myChannel); // Read
                chServer.send(req);
                System.out.println("Cliente "+id+" lee "+myChannel.receive());
            } else {
                req = new Req3("Write", id); // Write
                chServer.send(req);
            }
            sleep();
        }
    }

    private static void sleep() {
        try { Thread.sleep(400); }
        catch (InterruptedException _) { }
    }

    private static int getRandom() {
        Random r = new Random();
        return r.nextInt(3);
    }
}
