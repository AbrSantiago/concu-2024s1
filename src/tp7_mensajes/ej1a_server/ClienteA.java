package tp7_mensajes.ej1a_server;

import tp7_mensajes.Channel;

import java.util.Random;

public class ClienteA extends Thread {
    Channel channel;

    public ClienteA(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            sendRandomMsg();
            sleep500();
        }
    }

    private static void sleep500() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendRandomMsg() {
        Random random = new Random();
        int i = random.nextInt(5);
        if (i % 5 == 0) {
            channel.send("Cuenta");
            System.out.println("Cuenta");
        } else {
            channel.send("Sigue");
            System.out.println("Sigue");
        }
    }
}