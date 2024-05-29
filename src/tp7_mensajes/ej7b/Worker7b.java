package tp7_mensajes.ej7b;

import tp7_mensajes.Channel;

public class Worker7b extends Thread {
    int id;
    Channel chPW, ch1, chSW, ch4;

    public Worker7b(int id, Channel chPW, Channel ch1, Channel ch4) {
        this.id = id;
        this.chPW = chPW;
        this.ch1 = ch1;
        this.chSW = new Channel();
        this.ch4 = ch4;
    }

    @Override
    public void run() {
        while (true) {
            int i = (int) chPW.receive();
            Req7b req = new Req7b(chSW, i);
            ch1.send(req);
            Object msj = chSW.receive();
            ch4.send(msj);
            System.out.println(id+": Me llegó "+i+" y respondí "+ msj);
        }
    }
}