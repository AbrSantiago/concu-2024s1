package tp7_mensajes.ej6a;

import tp7_mensajes.Channel;

public class ServerT6a extends Thread {
    Channel chCT;
    Channel chTR;

    public ServerT6a(Channel chCT, Channel chTR) {
        this.chCT = chCT;
        this.chTR = chTR;
    }

    @Override
    public void run() {
        while (true) {
            String msj = (String) chCT.receive();
            String msjCodificado = codificar(msj);
            chTR.send(msjCodificado);
        }
    }

    private String codificar(String msj) {
        if (msj == null) { return null; }
        StringBuilder s = new StringBuilder(msj);
        return s.reverse().toString();
    }
}