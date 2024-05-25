package tp7_mensajes.ej6a;

import tp7_mensajes.Channel;

public class ServerR6a extends Thread {
    Channel chTR;

    public ServerR6a(Channel chTR) {
        this.chTR = chTR;
    }

    @Override
    public void run() {
        System.out.println(chTR.receive());
    }
}