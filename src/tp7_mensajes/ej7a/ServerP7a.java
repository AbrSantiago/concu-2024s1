package tp7_mensajes.ej7a;

import tp7_mensajes.Channel;

public class ServerP7a extends Thread {
    Channel ch1, ch2, ch3, ch4;

    public ServerP7a(Channel ch1, Channel ch2, Channel ch3, Channel ch4) {
        this.ch1 = ch1;
        this.ch2 = ch2;
        this.ch3 = ch3;
        this.ch4 = ch4;
    }

    @Override
    public void run() {
        while (true) {
            ch1.send(ch3.receive());
            ch4.send(ch2.receive());
        }
    }
}