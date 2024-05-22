package tp7_mensajes.ej2_server;

import tp7_mensajes.Channel;

public class Server2 extends Thread {
    Channel channel1;
    Channel channel2;

    public Server2(Channel ch1, Channel ch2) {
        this.channel1 = ch1;
        this.channel2 = ch2;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Received: " + channel1.receive() + channel2.receive());
        }
    }
}