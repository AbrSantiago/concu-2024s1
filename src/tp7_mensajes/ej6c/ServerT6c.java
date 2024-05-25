package tp7_mensajes.ej6c;

import tp7_mensajes.Channel;

public class ServerT6c extends Thread {
    Channel chCT;
    Channel chTR;
    Channel chKT;
    Req6c req;

    public ServerT6c(Channel chCT, Channel chKT) {
        this.chCT = chCT;
        this.chKT = chKT;
    }

    @Override
    public void run() {
        while (true) {
            req = (Req6c) chCT.receive();
            String key = (String) chKT.receive();
            if (req.channel != null) {
                chTR = req.channel;
            }
            String coded = code(req.msg, key);
            chTR.send(coded);
        }
    }

    private String code(String msg, String key) {
        if (msg == null) { return null; }
        StringBuilder s = new StringBuilder(msg);
        return key+ s.reverse();
    }
}