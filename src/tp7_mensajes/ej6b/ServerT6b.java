package tp7_mensajes.ej6b;

import tp7_mensajes.Channel;

public class ServerT6b extends Thread {
    Channel chCT;
    Channel chTR;
    Req6b req;

    public ServerT6b(Channel chCT) {
        this.chCT = chCT;
    }

    @Override
    public void run() {
        while (true) {
            req = (Req6b) chCT.receive();
//            System.out.println("T: Me llegó algo");
            if (req.channel != null) {
                chTR = req.channel;
            }
            String coded = code(req.msg);
            chTR.send(coded);
        }
    }

    private String code(String msj) {
        if (msj == null) { return null; }
        StringBuilder s = new StringBuilder(msj);
        return s.reverse().toString();
    }
}