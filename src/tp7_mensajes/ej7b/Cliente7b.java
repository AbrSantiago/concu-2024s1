package tp7_mensajes.ej7b;

import tp7_mensajes.Channel;
import java.util.Random;

public class Cliente7b extends Thread {
    Channel ch3, ch4;

    public Cliente7b(Channel ch3, Channel ch4) {
        this.ch3 = ch3;
        this.ch4 = ch4;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ch3.send(getRandom());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Recibo: "+ch4.receive());
        }
    }

    private int getRandom() {
        Random r = new Random();
        return r.nextInt(10);
    }
}