package tp7_mensajes.ej6a;

import tp7_mensajes.Channel;

public class Cliente6a extends Thread {
    Channel chCT;

    public Cliente6a(Channel chCT) {
        this.chCT = chCT;
    }

    @Override
    public void run() {
        chCT.send("mi contraseña");
    }
}