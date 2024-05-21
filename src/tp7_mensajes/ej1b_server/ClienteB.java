package tp7_mensajes.ej1b_server;

import tp7_mensajes.Channel;

import java.util.Random;

public class ClienteB extends Thread {
    Channel chClienteServer;
    Channel chServerCliente;

    public ClienteB(Channel chClienteServer, Channel chServerCliente) {
        this.chClienteServer = chClienteServer;
        this.chServerCliente = chServerCliente;
    }

    @Override
    public void run() {
        while (true) {
            if (gerRandom() % 5 == 0) {
                chClienteServer.send("Cuenta");
                System.out.println("Counter: "+chServerCliente.receive());
            } else {
                chClienteServer.send("Sigue");
            }
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

    private static int gerRandom() {
        Random random = new Random();
        return random.nextInt(5);
    }
}