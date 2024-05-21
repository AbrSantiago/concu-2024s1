package tp7_mensajes.ej1a_server;

import tp7_mensajes.Channel;

public class ServerA extends Thread {
    Channel channel;
    int counter = 0;

    public ServerA(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Object msj = channel.receive();
            if (msj == "Cuenta") {
                System.out.println("Se recibieron "+counter+" 'sigue'");
                counter = 0;
            } else if (msj == "Sigue"){
                counter++;
            }
        }
    }
}