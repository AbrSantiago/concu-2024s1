package tp7_mensajes.ej6c;

import tp7_mensajes.Channel;

import java.util.ArrayList;
import java.util.Random;

public class Cliente6c extends Thread {
    Channel chCT;
    ArrayList<Channel> channels;

    public Cliente6c(Channel chCT, ArrayList<Channel> chs) {
        this.chCT = chCT;
        this.channels = chs;
    }

    @Override
    public void run() {
        Req6c req = new Req6c(getAny(channels), "Mi contraseña");
        chCT.send(req);
        while (true) {
            sleep300();
            if (getRandom(3) % 3 == 0) {
                Channel ch = getAny(channels);
                chCT.send(new Req6c(ch, "Mi contraseña"));
                System.out.println("mandé ch: " + ch);
            } else {
                chCT.send(new Req6c("Mi contraseña"));
//                System.out.println("mandé solo msj");
            }
        }
    }

    private void sleep300() {
        try { Thread.sleep(300); }
        catch (InterruptedException _) { }
    }

    private <T> T getAny(ArrayList<T> chs) {
        return chs.get(getRandom(5));
    }

    private int getRandom(int bound) {
        Random r = new Random();
        return r.nextInt(bound);
    }
}