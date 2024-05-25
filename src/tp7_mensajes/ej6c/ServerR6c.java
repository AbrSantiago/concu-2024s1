package tp7_mensajes.ej6c;

import tp7_mensajes.Channel;

public class ServerR6c extends Thread {
    Channel chTR;
    int id;

    public ServerR6c(int id, Channel chTR) {
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