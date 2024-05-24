package tp7_mensajes.ej5;

import tp7_mensajes.Channel;
import java.util.Random;

public class Cliente5 extends Thread {
    int id;
    Channel chServer;
    Channel chClientToThread;
    Channel chThreadToClient;

    public Cliente5(int id, Channel chServer) {
        this.id = id;
        this.chServer = chServer;
        this.chClientToThread = new Channel();
        this.chThreadToClient = new Channel();
    }

    @Override
    public void run() {
        Req5 req = new Req5(chClientToThread, chThreadToClient);
        chServer.send(req);
        chClientToThread.send(getRandomN());
        boolean win = (boolean) chThreadToClient.receive();
        while (!win) {
            System.out.println(id+": No acerté... Probando con otro :p");
            chClientToThread.send(getRandomN());
            win = (boolean) chThreadToClient.receive();
            sleep200();
        }
        System.out.println(id+": Gané! A mimir");
    }

    private static int getRandomN() {
        Random r = new Random();
        return r.nextInt(11);
    }

    private static void sleep200() {
        try { Thread.sleep(200); }
        catch (InterruptedException _) { }
    }
}