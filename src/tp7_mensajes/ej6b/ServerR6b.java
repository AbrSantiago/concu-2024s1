package tp7_mensajes.ej6b;

import tp7_mensajes.Channel;

public class ServerR6b extends Thread {
    Channel chTR;
    int id;

    public ServerR6b(int id, Channel chTR) {
        this.id = id;
        this.chTR = chTR;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(id+": "+chTR.receive());
        }
    }
}