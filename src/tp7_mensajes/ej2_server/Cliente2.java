package tp7_mensajes.ej2_server;

import tp7_mensajes.Channel;

import java.util.Random;

public class Cliente2 extends Thread {
    int id;
    Channel channel;

    public Cliente2(int id, Channel ch) {
        this.id = id;
        this.channel = ch;
    }

    @Override
    public void run() {
        while (true) {
            channel.send(id);
            sleepRandom();
        }
    }

    private static void sleepRandom() {
        try {
            Thread.sleep(getRandom());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getRandom() {
        Random r = new Random();
        return 100 + 100 * r.nextInt(5);
    }
}